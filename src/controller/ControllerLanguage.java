
package src.controller;

import src.model.langage.*;
import src.view.langage.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class ControllerLanguage extends MouseAdapter {
    
    UserCode model;
    LanguageView view;

    IMouseReactive source;
    IMouseReactive dest;

    public ControllerLanguage(UserCode userCode) {
        model = userCode;
    }

    public void setView(LanguageView v) {
        view = v;
    } 

    public void setSource(IMouseReactive src) {
        source = src;
    }

    public void mousePressed(MouseEvent me) {
        IMouseReactive src = (IMouseReactive) me.getSource();
            
        view.mousePressed(src);
        
    } 

    public void mouseEntered(MouseEvent me) {
        IMouseReactive dst = (IMouseReactive)me.getSource();
        if (!dst.getDestType().equals("null"))
            dest = dst;
    }
    public void mouseExited(MouseEvent me) {
        IMouseReactive dst = (IMouseReactive)me.getSource();
        if (dest == dst) {
            dest = null;
        }
    }

    public void mouseReleased(MouseEvent me) {
        
        view.mouseReleased(source, dest);

        view.setMovableObject(null);
        source = null;
        view.revalidate();
    } 

    public void mouseDragged(MouseEvent me) {
        if (source == null) 
            return;
        
        //JPanel src = (JPanel) source;
        // dessiner panel
    } 

}