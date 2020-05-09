
package src.view.langage;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Point;

import src.controller.ControllerLanguage;

            
public interface IConditionPanelAdjustable extends IParent {
    
    default InstructionPanel removeConditionPanel() {
        InstructionPanel parent = ((InstructionPanel)this);
        ConditionPanel cp = this.getConditionPanel();
        ControllerLanguage controller = parent.getController();
        ConditionPanel newcp = ControlFlowStatementPanel.createEmptyConditionPanel(this, controller);

        parent.remove(cp);
        parent.add(newcp);

        setConditionPanel(newcp);        
        newcp.setParentPanel(this);

        findEditPanel().updatePlacement();   

        return newcp;
    }

    default void addConditionPanel(ConditionPanel newcp) {
        InstructionPanel parent = ((InstructionPanel)this);

        parent.remove(getConditionPanel());
        parent.add(newcp);

        setConditionPanel(newcp);        
        newcp.setParentPanel(this);
        
        findEditPanel().updatePlacement();   
    }

    void setConditionPanel(ConditionPanel cp);
    ConditionPanel getConditionPanel();

    default void setToDragAndDropLayer(InstructionPanel ip, JLayeredPane layeredPanel) {
        layeredPanel.setLayer(ip, JLayeredPane.DRAG_LAYER); 
        ip.highlight();
        layeredPanel.add(ip);        
    }
    default void setToDefaultLayer(InstructionPanel ip, JLayeredPane layeredPanel) {
        layeredPanel.setLayer(ip, JLayeredPane.DEFAULT_LAYER);
        ip.dehighlight();
    }

    default EditPanel findEditPanel() {
        IParent p = ((InstructionPanel)this).getParentPanel();
        while (!(p instanceof EditPanel)) {
            p = ((InstructionPanel)p).getParentPanel();
        }
        return (EditPanel)p;
    }
    
    default InstructionPanel removePanel(InstructionPanel ip) {
        return removeConditionPanel();
    }
}