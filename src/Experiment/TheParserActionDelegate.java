package Experiment;

import parsers.Parser;

import java.util.function.Consumer;

public interface TheParserActionDelegate {
    void performParserAction(Consumer<Parser> p);
}
