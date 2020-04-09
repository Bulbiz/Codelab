
package src.editor.view;

import javax.swing.*;
import src.controller.ControllerEditor;
import java.awt.*;
import java.awt.Dimension;

public class GeneratorsPanel extends JPanel {
    private ControllerEditor controller;
    private DecorGeneratorPanel decor;
    private CollectableGeneratorPanel collectable;
    private PersonageGeneratorPanel personage;
    private EraserGeneratorPanel eraser;
    
    public GeneratorsPanel(ControllerEditor c) {
        controller = c;
        this.decor = new DecorGeneratorPanel(c);
        this.collectable = new CollectableGeneratorPanel(c);
        this.personage = new PersonageGeneratorPanel(c);
        this.eraser = new EraserGeneratorPanel(c);
        layoutPlacement();
    }
    private void layoutPlacement() {
    	this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    	this.addButton();
    }
    
    private void addButton() {
    	this.addWithSeparation(decor);
    	this.addWithSeparation(collectable);
    	this.addWithSeparation(personage);
    	this.addWithSeparation(eraser);
    }
    
    private void addWithSeparation(JComponent c) {
    	this.add(c);
    	this.add(Box.createRigidArea(new Dimension(0,20)));
    }
}