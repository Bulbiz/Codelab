
package src.controller;

import src.model.langage.*;
import src.view.langage.*;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.border.*;

public class ControllerLanguage extends MouseAdapter {
    
    UserCode model;
    LanguageView view;

    InstructionPanel source;
    IMouseReactive dest;

    public ControllerLanguage(UserCode userCode) {
        model = userCode;
    }

    public void setView(LanguageView v) {
        view = v;
    } 

    public void setSource(IMouseReactive src) {
        source = (InstructionPanel) src;
    }

    public void mousePressed(MouseEvent me) {
        IMouseReactive src = (IMouseReactive) me.getSource();
            
        view.mousePressed(src);
        dest = source;
    } 

    public void mouseEntered(MouseEvent me) {
        if (source == null)
            return;

        IMouseReactive dst = (IMouseReactive)me.getSource();
        if (!dst.getDestType().equals("null")) {
            dest = dst;
            JComponent d = (JComponent) dest;
            d.setBorder(new LineBorder(Color.red));
        }
    }
    public void mouseExited(MouseEvent me) {
        if (source == null)
            return;

        IMouseReactive dst = (IMouseReactive)me.getSource();

        if (dest == dst) {
            JComponent d = (JComponent) dest;
            d.setBorder(new LineBorder(Color.black));
            dest = null;
        }
    }

    public void mouseReleased(MouseEvent me) {
        
        view.mouseReleased(source, dest);

        if (dest != null) {
            JComponent d = (JComponent) dest;
            d.setBorder(new LineBorder(Color.black));
            dest = null;
        }

        source = null;
        view.updateUI();
    } 

    public void mouseDragged(MouseEvent me) {
        if (source == null) 
            return;
    } 

}