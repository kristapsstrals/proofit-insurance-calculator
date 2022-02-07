package proofit.insurance.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class PolicyObject {
    private String name;
    private ArrayList<PolicySubObject> subObjects;

    public PolicyObject() {
    }

    public PolicyObject(String name) {
        this.name = name;
        this.subObjects = new ArrayList<PolicySubObject>();
    }

    public PolicyObject(String name, ArrayList<PolicySubObject> subObjects) {
        this.name = name;
        this.subObjects = subObjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void getSubObjects(ArrayList<PolicySubObject> subObjects) {
        this.subObjects = subObjects;
    }

    public List<PolicySubObject> getSubObjects() {
        return this.subObjects;
    }

    public void AddSubObject(PolicySubObject subObject) {

        this.subObjects.add(subObject);
    }
}
