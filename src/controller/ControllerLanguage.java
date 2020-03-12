
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

        if (src.getSourceType().equals("null"))
            return;      

        switch (src.getSourceType()) {
            case "generatorPanel": view.mousePressedGenerator((InstructionPanelGenerator)src); break;
            case "instructionPanel": view.mousePressedInstructionPanel((InstructionPanel)src); break;
        }
        
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
        if (dest != null && source != null) {
            switch (dest.getDestType()) {
                case "instructionPanel": view.mouseReleasedOverInstructionPanel((InstructionPanel)dest, (InstructionPanel)source); break;
            }
        }

        view.setMovableObject(null);
        source = null;
        view.revalidate();
    } 

    public void mouseDragged(MouseEvent me) {
        System.out.println("drag");
        if (source == null) 
            return;
        
        //JPanel src = (JPanel) source;
        // dessiner panel
    } 
    
}