package src.view.language;

import src.controller.ControllerLanguage;
import src.model.language.Begin;

public class BeginPanel extends ActionPanel {

    public BeginPanel(ControllerLanguage controller, Begin begin) {
        super(controller, begin);
    }

    public boolean needCursorHand() {
        return false;
    }

    public void delete() { }

}