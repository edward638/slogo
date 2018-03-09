package Experiment;

import view.GUI;

public abstract class TheController {
    private GUI gui;
    public TheController(GUI gui){
        this.gui = gui;
    }
    protected abstract void initializeScreenComponents();
    protected abstract void setUpConnections();
    protected abstract void addToGUI();
    protected GUI getGui(){
        return gui;
    }
}
