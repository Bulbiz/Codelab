package src.view.world;

import java.util.ArrayList;

import javax.swing.JPanel;

import src.model.world.Collectable;
import java.awt.Graphics;

public class InventoryPanel extends JPanel {

    ArrayList<Collectable> inventory;

    public InventoryPanel(ArrayList<Collectable> inventory) {
        this.inventory = inventory;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawInventory(spriteLibrary, g);
    }

    public void drawInventory(ImageLibrary spriteLibrary, Graphics g) {

        for (int i = 0; i < inventory.size(); i++) {
            Collectable c = inventory.get(i);
            String entitySpriteName = c.toString();
            int length = WorldPanel.tileLength;
            spriteLibrary.getSprite(entitySpriteName).paintIcon(this,g, 0, i*length);
        }
    }
}