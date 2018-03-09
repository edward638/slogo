package Experiment;


import model.VariablesHistory;
import view.GUI;
import view.screen_components.VariableHistoryBox;

public class TheVariableHistoryBoxController extends TheController implements TheClearValueDelegate, TheValueModifierDelegate {
    private VariablesHistory variablesHistory;
    private VariableHistoryBox variableHistoryBox;
    public TheVariableHistoryBoxController(GUI gui, VariablesHistory variablesHistory){
        super(gui);
        this.variablesHistory = variablesHistory;
    }

    @Override
    protected void initializeScreenComponents() {
        variableHistoryBox = new VariableHistoryBox();
    }

    @Override
    protected void setUpConnections() {
        variableHistoryBox.setClearValueDelegate(this);
        variableHistoryBox.setValueModifierDelegate(this);
        variableHistoryBox.setVariableHistory(variablesHistory);
        variablesHistory.addObserver(variableHistoryBox);
    }


    @Override
    protected void addToGUI() {
        super.getGui().addToScreen(variableHistoryBox);
    }

    @Override
    public void clear() {
        variablesHistory.clearHistory();
    }

    @Override
    public void changeValue(String value, String variableName) {
        variablesHistory.changeValue(value, variableName);
    }
}
