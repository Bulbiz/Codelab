package src.view.world;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import src.model.world.Collectable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class InventoryPanel extends JPanel {

    ArrayList<Collectable> inventory;
    ImageLibrary spriteLibrary;
    int ymarge = 10;
    int xmarge = 5;
    int spaceBetweenItems = 4;

    public InventoryPanel(ArrayList<Collectable> inventory, ImageLibrary spriteLibrary) {
        this.inventory = inventory;
        this.spriteLibrary = spriteLibrary;

        setBorder(new TitledBorder(new LineBorder(Color.BLACK), "inventory"));
        setMinimumSize(new Dimension(WorldPanel.tileLength, WorldPanel.tileLength + ymarge * 2));
        setPreferredSize(new Dimension(WorldPanel.tileLength, WorldPanel.tileLength + ymarge * 2));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawInventory(spriteLibrary, g);
    }

    public void drawInventory(ImageLibrary spriteLibrary, Graphics g) {

        for (int i = 0; i < inventory.size(); i++) {
            Collectable c = inventory.get(i);
            String entitySpriteName = c.toString();
            int length = WorldPanel.tileLength;
            spriteLibrary.getSprite(entitySpriteName).paintIcon(this,g, xmarge + i*(length + spaceBetweenItems), ymarge + ymarge / 2);
        }
    }
}