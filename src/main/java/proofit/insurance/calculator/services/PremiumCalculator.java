package proofit.insurance.calculator.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import proofit.insurance.calculator.domain.Policy;
import proofit.insurance.calculator.domain.RiskType;

public class PremiumCalculator {

    public BigDecimal calculate(Policy policy) {
        var firePremium = calculatePremiumForRiskType(policy, RiskType.FIRE);
        var theftPremium = calculatePremiumForRiskType(policy, RiskType.THEFT);
        var insurancePremium = firePremium.add(theftPremium);

        // return two decimal places as that is what's requested in the acceptance
        // criteria
        return insurancePremium.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculatePremiumForRiskType(Policy policy, RiskType riskType) {
        var sumInsured = getInsuranceSum(policy, riskType);
        var coefficient = getPremiumCoefficient(sumInsured, riskType);
        return sumInsured.multiply(coefficient);
    }

    private BigDecimal getInsuranceSum(Policy policy, RiskType riskType) {
        return policy.getPolicyObjects()
                .stream()
                .map(policyObject -> {
                    var sumInsured = policyObject.getSubObjects()
                            .stream()
                            .filter(subObject -> {
                                return subObject.getRiskType() == riskType;
                            })
                            .map(subObject -> subObject.getSumInsured())
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    return sumInsured;
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getPremiumCoefficient(BigDecimal insuranceSum, RiskType riskType) {
        switch (riskType) {
            case FIRE:
                if (insuranceSum.compareTo(new BigDecimal(100)) > 0) {
                    return BigDecimal.valueOf(0.024);
                }

                return BigDecimal.valueOf(0.014);
            case THEFT:
                if (insuranceSum.compareTo(new BigDecimal(15)) > 0) {
                    return BigDecimal.valueOf(0.05);
                }

                return BigDecimal.valueOf(0.11);
            default:
                throw new IllegalStateException(String.format("Unsupported risk type: %s", riskType));
        }
    }
}
