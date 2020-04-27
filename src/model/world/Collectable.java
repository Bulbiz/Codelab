package src.model.world;

public abstract class Collectable extends Entity {

    public Collectable(Board b, int xStart, int yStart) {
        super(b, xStart, yStart);
    }

    public void isCollected(Player player) {
        player.addToInventory(this);
        levelBoard.erased(y, x);
    }

}