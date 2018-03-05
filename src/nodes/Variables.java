package nodes;

import model.VariablesHistory;

/**
 * This abstract class defines any type who has a name and needs access to the variables history. Any
 * user made command will be a part of variables. It stores a name and VH.
 *
 * author: Charlie Dracos
 */
public abstract class Variables {
    protected String name;
    protected VariablesHistory VH;

    /**
     * Constructor which stores the name of the variable and the variables history
     * @param name of the user input command/variable
     * @param VH variables history which can be accessed/used
     */
    public Variables(String name, VariablesHistory VH) {
        this.name = name;
        this.VH = VH;
    }

    public String getName() {
        return name; //returns name
    }

    public VariablesHistory getVH() {
        return VH; //returns the VH
    }
 }
