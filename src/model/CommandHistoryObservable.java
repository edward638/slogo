package model;

import java.util.List;

public interface CommandHistoryObservable {
    public void clearHistory();
    public List<String> getCommands();
}
