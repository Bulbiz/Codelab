
package src.view.langage;

import javax.swing.JPanel;

import src.controller.ControllerLanguage;

            
public interface IConditionPanelAdjustable extends IParent {
    void changeConditionPanel(ConditionPanel cp);
    default void changeConditionPanel(ConditionPanel cp, JPanel conditionPanelPanel, ControllerLanguage controller) {
        if (cp.getParentPanel() != this) {
            IConditionPanelAdjustable parent = (IConditionPanelAdjustable)cp.getParentPanel();
            if (parent != null)
                parent.changeConditionPanel(ControlFlowStatementPanel.createEmptyConditionPanel(parent, controller));
        }

        conditionPanelPanel.remove(getConditionPanel());
        setConditionPanel(cp);
        getConditionPanel().setParentPanel(this);
        conditionPanelPanel.add(cp);
        
    }

    void setConditionPanel(ConditionPanel cp);
    ConditionPanel getConditionPanel();
}