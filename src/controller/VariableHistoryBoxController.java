package controller;


import model.VariablesHistory;
import view.GUI;
import view.screen_components.VariableHistoryBox;

public class VariableHistoryBoxController extends Controller implements ClearValueDelegate, ValueModifierDelegate {
    private VariablesHistory variablesHistory;
    private VariableHistoryBox variableHistoryBox;
    public VariableHistoryBoxController(GUI gui, VariablesHistory variablesHistory){
        super(gui);
        this.variablesHistory = variablesHistory;
    }

    @Override
    protected void initializeScreenComponents() {
        variableHistoryBox = new VariableHistoryBox((ValueModifierDelegate)this, (ClearValueDelegate) this);
    }

    @Override
    protected void setUpConnections() {
        variableHistoryBox.setVariableHistory(variablesHistory);
        variablesHistory.addVariableObserver(variableHistoryBox);
    }

    @Override
    protected void addToGUI() {
        super.getGui().addToScreen(variableHistoryBox);
    }

    @Override
    public void clear() {
        variablesHistory.clearVariableHistory();
    }

    @Override
    public void changeValue(String value, String variableName) {
        variablesHistory.changeValue(value, variableName);
    }
}
