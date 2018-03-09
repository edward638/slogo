package Experiment;

import javafx.scene.paint.Color;
import model.Model;
import view.GUI;
import view.screen_components.Drawer;
import view.screen_components.TheDrawer;

public class TheDrawerController extends TheController implements ThePaletteDelegate{
    private TheDrawer drawer;
    private Model model;
    public TheDrawerController(GUI gui, Model model){
        super(gui);
        this.model = model;
    }

    @Override
    protected void initializeScreenComponents() {
        drawer = new TheDrawer();
    }

    @Override
    protected void setUpConnections() {
        drawer.setTurtlesFetcher(model);
        drawer.setThePaletteDelegate(this);
        drawer.notifyOfChanges();
        model.addDrawerObserver(drawer);
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
