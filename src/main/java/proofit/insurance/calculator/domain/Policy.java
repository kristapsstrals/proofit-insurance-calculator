package proofit.insurance.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Policy {
    private String number;
    private PolicyStatus status;
    private ArrayList<PolicyObject> policyObjects;

    public Policy() {
    }

    public Policy(String number, PolicyStatus status, ArrayList<PolicyObject> policyObjects) {
        this.number = number;
        this.status = status;
        this.policyObjects = policyObjects;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    public PolicyStatus getStatus() {
        return this.status;
    }

    public void setPolicyObjects(ArrayList<PolicyObject> policyObjects) {
        this.policyObjects = policyObjects;
    }

    public List<PolicyObject> getPolicyObjects() {
        return this.policyObjects;
    }
}
