package Experiment;

import javafx.scene.paint.Color;
import model.Model;
import view.GUI;
import view.screen_components.Drawer;

public class TheDrawerController extends TheController implements ThePaletteDelegate{
    private Drawer drawer;
    private Model model;
    public TheDrawerController(GUI gui, Model model){
        super(gui);
        this.model = model;
    }

    @Override
    protected void initializeScreenComponents() {
        drawer = new Drawer();
    }

    @Override
    protected void setUpConnections() {
        drawer.setThePaletteDelegate(this);
        drawer.setTurtle(model.getActiveTurtles().get(0));
        drawer.notifyOfChanges();
        model.getActiveTurtles().get(0).addObserver(drawer);
    }

    @Override
    protected void addToGUI() {
        super.getGui().addToScreen(drawer);
    }

    @Override
    public void changeBackgroundColor(Color color) {
        //TODO:fix
        model.setBackgroundColor(0);
    }

    @Override
    public void changePenColor(Color color) {
        model.update((t)->t.setPenColor(color));
    }

    @Override
    public void changeTurtleImage(String image) {
        model.update((t)->t.setTurtleShape(image));
    }
}
