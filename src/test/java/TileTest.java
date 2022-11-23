import oop.blueprints.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TileTest {

    @Test
    public void testConstructor() {
        Tile testTile = new Tile();
        Assertions.assertEquals(false, testTile.isRevealed(), "Test tile incorrectly generated" +
                " as revealed");
        Assertions.assertEquals(0,testTile.getNearBombs(), "Test tile doesn't have 0 near bombs.");
    }

    @Test
    public void testSettersAndGetters() {
        Tile testTile = new Tile();
        testTile.setFlagged(true);
        testTile.setRevealed(true);
        testTile.setBomb(true);
        testTile.setNearBombs(5);

        Assertions.assertEquals(true,testTile.isFlagged(),"Tile has not been successfully flagged.");
        Assertions.assertEquals(true, testTile.isRevealed(), "Tile has not been revealed");
        Assertions.assertEquals(true, testTile.isBomb(),"Tile has not been set as a bomb.");
        Assertions.assertEquals(5,testTile.getNearBombs(), "Tile does not have 5 bombs.");

    }

}
