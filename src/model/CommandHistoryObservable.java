package model;

import java.util.List;

public interface CommandHistoryObservable {
    void clearHistory();
    List<String> getCommands();
}
