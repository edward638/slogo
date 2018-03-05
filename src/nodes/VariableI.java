package nodes;

import model.VariableHistory;

public abstract class VariableI {
    protected String name;
    protected VariableHistory VH;

    public VariableI (String name, VariableHistory VH) {
        this.name = name;
        this.VH = VH;
    }

    public String getName() {
        return name;
    }

    public VariableHistory getVH() {
        return VH; //returns the VH
    }
 }
