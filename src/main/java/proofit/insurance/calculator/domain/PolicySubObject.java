package proofit.insurance.calculator.domain;

import java.math.BigDecimal;

public class PolicySubObject {
    private String name;
    private BigDecimal sumInsured;

    // TODO: should this be a list of risk types that this is insured for?
    private RiskType riskType;

    public PolicySubObject() {
    }

    public PolicySubObject(String name, BigDecimal sumInsured, RiskType riskType) {
        this.name = name;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public BigDecimal getSumInsured() {
        return this.sumInsured;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    public RiskType getRiskType() {
        return this.riskType;
    }
}
