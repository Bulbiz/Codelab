
package src.controller;

import src.model.langage.*;
import src.view.langage.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.*;

public class ControllerLanguage extends MouseAdapter {
    
    UserCode model;
    LanguageView view;

    InstructionPanel source;
    InstructionPanel sourcePrevious;
    int sourceClickX;

    IMouseReactive dest;

    JFrame frame;
    Cursor hand, classic;

    public ControllerLanguage(UserCode userCode) {
        model = userCode;        

        hand = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        classic = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
    }

    public void setFrame(JFrame f) {
        frame = f;
    }

    public void setView(LanguageView v) {
        view = v;
    } 

    public void setSource(IMouseReactive src) {
        source = (InstructionPanel) src;
        sourcePrevious = null;
    }

    public InstructionPanel getSource() {
        return source;
    }

    public InstructionPanel getSourcePrevious() {
        return sourcePrevious;
    }

    public void setSourcePrevious(InstructionPanel ip) {
        sourcePrevious = ip;
    }

    private Point locateMouse(MouseEvent me) {
        Point p = me.getLocationOnScreen();
        int eventx = (int)p.getX();
        int eventy = (int)p.getY();

        p = view.getLocationOnScreen();
        int mousex = eventx - (int)p.getX();
        int mousey = eventy - (int)p.getY();   

        return new Point(mousex, mousey);
    }    

    public void mousePressed(MouseEvent me) {
        IMouseReactive src = (IMouseReactive) me.getSource();

        Point mouse = locateMouse(me);     
        sourceClickX = me.getX();
        view.mousePressed(src, 
            (int)mouse.getX() - sourceClickX, 
            (int)mouse.getY() - 16);

        if (source != null)
            frame.setCursor(hand);
    } 

    public void mouseEntered(MouseEvent me) {
        IMouseReactive src = (IMouseReactive)me.getSource();
        if (src.needCursorHand())
            frame.setCursor(hand);

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
        if (source == null) {
            frame.setCursor(classic);
            return;
        }

        IMouseReactive dst = (IMouseReactive)me.getSource();

        if (dest == dst) {
            JComponent d = (JComponent) dest;
            d.setBorder(new LineBorder(Color.black));
            dest = null;
        }
    }

    public void mouseReleased(MouseEvent me) {
        if (source == null)
            return;

        if (dest == null)
           frame.setCursor(classic);
        
            
        if (source.getParentPanel() != null)
            source.getParentPanel().setToDefaultLayer(source, view);
        else {
            view.setLayer(source, JLayeredPane.DEFAULT_LAYER);
            view.remove(source);
        }           
        
        if (source.getParentPanel() == null && dest == null)
            source.delete();
        else {
            
            boolean success = false;
            if (dest != null)
                success = dest.onRelease(source);    
            if (!success && sourcePrevious != null)
                success = sourcePrevious.onRelease(source);
            if (!success)   
                source.delete(); 
            
            if (dest != null) {
                JComponent d = (JComponent) dest;
                d.setBorder(new LineBorder(Color.black));
                dest = null;   
            }     
            
            source = null;
            view.revalidate();
        }
        
    }

    public void mouseDragged(MouseEvent me) {
        if (source == null)
            return;

        Point mouse = locateMouse(me);   
        view.mouseDrag(source, 
            (int)mouse.getX() - sourceClickX, 
            (int)mouse.getY() - 16);
        
    }

    public void displayView() {
        view.revalidate();
    }

}