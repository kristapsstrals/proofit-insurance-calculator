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

        var expected = new BigDecimal(2.28);
        assertEquals(expected, result);
    }
}
