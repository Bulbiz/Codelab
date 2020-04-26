
package src.editor.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import src.controller.ControllerEditor;
import java.awt.*;

public class GeneratorsPanel extends JPanel {

    private JTextField nameLoad;
    private JButton load;
    private ControllerEditor controller;
    private DecorGeneratorPanel decor;
    private CollectableGeneratorPanel collectable;
    private PersonageGeneratorPanel personage;
    private JTextField name;
    private JButton create;
    private EraserGeneratorPanel eraser;


    public GeneratorsPanel(ControllerEditor c) {
        controller = c;
        this.nameLoad = fieldNameLoad();
        this.load = buttonLoad();
        this.decor = new DecorGeneratorPanel(c);
        this.collectable = new CollectableGeneratorPanel(c);
        this.personage = new PersonageGeneratorPanel(c);
        this.name = fieldName();
        this.create = buttonCreate();
        this.eraser = new EraserGeneratorPanel(c);
        layoutPlacement();
        this.setBorder(new TitledBorder(new LineBorder(Color.blue), "Palette"));
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

    private JTextField fieldNameLoad() {
    	JTextField text = new JTextField ("LevelName",20);
    	text.setMaximumSize(text.getPreferredSize());
    	return text;
    }

    private JButton buttonCreate() {
    	JButton c = new JButton ("Create");
    	c.addActionListener((e)-> controller.create(name.getText()));
    	return c;
    }

    private JButton buttonLoad() {
    	JButton c = new JButton ("Load");
    	c.addActionListener((e)-> controller.load(nameLoad.getText()));
    	return c;
    }

    private void addButton() {
        this.addWithSeparation(nameLoad);
        this.addWithSeparation(load);
    	this.addWithSeparation(decor);
    	this.addWithSeparation(collectable);
    	this.addWithSeparation(personage);
    	this.addWithSeparation(name);
    	this.addWithSeparation(create);
    	this.addWithSeparation(eraser);
    }

    private void addWithSeparation(JComponent c) {
    	this.add(c);
    	this.add(Box.createRigidArea(new Dimension(0,20)));
    }
}
