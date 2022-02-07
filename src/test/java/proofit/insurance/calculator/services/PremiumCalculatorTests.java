package proofit.insurance.calculator.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import proofit.insurance.calculator.domain.Policy;
import proofit.insurance.calculator.domain.PolicyObject;
import proofit.insurance.calculator.domain.PolicyStatus;
import proofit.insurance.calculator.domain.PolicySubObject;
import proofit.insurance.calculator.domain.RiskType;

@SpringBootTest
public class PremiumCalculatorTests {
    private PremiumCalculator calculator;

    public PremiumCalculatorTests() {
        this.calculator = new PremiumCalculator();
    }

    /**
     * Test case for the first acceptance criteria:
     * If there is one policy, one object and two sub-objects as described below,
     * then calculator should return
     * premium = 2.28 EUR
     * Risk type = FIRE, Sum insured = 100.00
     * Risk type = THEFT, Sum insured = 8.00
     */
    @Test
    void Test_CanCalculatePremium_OneObjectTwoSubObjects() {
        var policy = new Policy(
                "TEST_POLICY_NUMBER",
                PolicyStatus.APPROVED,
                new ArrayList<PolicyObject>() {
                    {
                        add(
                                new PolicyObject(
                                        "Home",
                                        new ArrayList<PolicySubObject>() {
                                            {
                                                add(
                                                        new PolicySubObject(
                                                                "TV",
                                                                new BigDecimal(100.00),
                                                                RiskType.FIRE));
                                                add(
                                                        new PolicySubObject(
                                                                "PC",
                                                                new BigDecimal(8.00),
                                                                RiskType.THEFT));
                                            }
                                        }));
                    }
                });

        var result = this.calculator.calculate(policy);

        var expected = BigDecimal.valueOf(2.28);
        assertEquals(expected, result);
    }

    /**
     * Test case for the second acceptance criteria:
     * If policy's total sum insured for risk type FIRE and total sum insured for
     * risk type THEFT are as
     * described below, then calculator should return premium = 17.13 EUR
     * Risk type = FIRE, Sum insured = 500.00
     * Risk type = THEFT, Sum insured = 102.51
     */
    @Test
    void Test_CanCalculatePremium_SumBasedTest() {
        var policy = new Policy(
                "TEST_POLICY_NUMBER",
                PolicyStatus.APPROVED,
                new ArrayList<PolicyObject>() {
                    {
                        add(
                                new PolicyObject(
                                        "Home",
                                        new ArrayList<PolicySubObject>() {
                                            {
                                                add(
                                                        new PolicySubObject(
                                                                "TV",
                                                                new BigDecimal(200.00),
                                                                RiskType.FIRE));
                                                add(
                                                        new PolicySubObject(
                                                                "PC",
                                                                new BigDecimal(50.00),
                                                                RiskType.THEFT));
                                            }
                                        }));
                        add(
                                new PolicyObject(
                                        "Work",
                                        new ArrayList<PolicySubObject>() {
                                            {
                                                add(
                                                        new PolicySubObject(
                                                                "TV",
                                                                new BigDecimal(200.00),
                                                                RiskType.FIRE));
                                                add(
                                                        new PolicySubObject(
                                                                "PC",
                                                                new BigDecimal(50.00),
                                                                RiskType.THEFT));
                                            }
                                        }));
                        add(
                                new PolicyObject(
                                        "Some Thid Object",
                                        new ArrayList<PolicySubObject>() {
                                            {
                                                add(
                                                        new PolicySubObject(
                                                                "TV",
                                                                new BigDecimal(100.00),
                                                                RiskType.FIRE));
                                                add(
                                                        new PolicySubObject(
                                                                "PC",
                                                                new BigDecimal(2.51),
                                                                RiskType.THEFT));
                                            }
                                        }));
                    }
                });

        var result = this.calculator.calculate(policy);

        var expected = BigDecimal.valueOf(17.13);
        assertEquals(expected, result);
    }
}
