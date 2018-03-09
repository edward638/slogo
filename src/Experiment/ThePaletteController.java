package Experiment;

import model.Model;
import view.GUI;
import view.screen_components.Palette;

public class ThePaletteController extends TheController{
    private Model model;
    private Palette palette;
    public ThePaletteController(GUI gui, Model model){
        super(gui);
        this.model = model;
    }

    @Override
    protected void initializeScreenComponents() {
        palette = new Palette();
    }

    @Override
    protected void setUpConnections() {
        palette.setColorIndex(model);
        model.addObserver(palette);
    }

    @Override
    protected void addToGUI() {
        super.getGui().addToScreen(palette);
    }
}