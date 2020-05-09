package src.view.langage;

import src.controller.ControllerLanguage;
import src.model.langage.Begin;

public class BeginPanel extends ActionPanel {

    public BeginPanel(ControllerLanguage controller, Begin begin) {
        super(controller, begin);
    }

    public boolean needCursorHand() {
        return false;
    }

    public void delete() { }

}