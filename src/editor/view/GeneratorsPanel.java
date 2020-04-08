
package src.editor.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import src.controller.ControllerEditor;
import java.awt.*;
import java.awt.Dimension;

public class GeneratorsPanel extends JPanel {
    private ControllerEditor controller;
    private DecorGeneratorPanel decor;
    private CollectableGeneratorPanel collectable;
    private PersonageGeneratorPanel personage;
    private JTextField name;
    private JButton create;
    
    public GeneratorsPanel(ControllerEditor c) {
        controller = c;
        this.decor = new DecorGeneratorPanel(c);
        this.collectable = new CollectableGeneratorPanel(c);
        this.personage = new PersonageGeneratorPanel(c);
        this.name = fieldName();
        this.create = buttonCreate();
        layoutPlacement();
    }
    
    private void layoutPlacement() {
    	this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    	this.addButton();
    }
    private JTextField fieldName() {
    	JTextField text = new JTextField ("LevelName",20);
    	text.setMaximumSize(text.getPreferredSize());
    	return text;
    }
    
    private JButton buttonCreate() {
    	JButton c = new JButton ("Create");
    	c.addActionListener((e)-> controller.create(name.getName()));
    	return c;
    }
    
    private void addButton() {
    	this.addWithSeparation(decor);
    	this.addWithSeparation(collectable);
    	this.addWithSeparation(personage);
    	this.addWithSeparation(name);
    	this.addWithSeparation(create);
    }
    
    private void addWithSeparation(JComponent c) {
    	this.add(c);
    	this.add(Box.createRigidArea(new Dimension(0,20)));
    }
}