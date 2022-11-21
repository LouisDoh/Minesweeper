import oop.blueprints.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridTest {

    @Test
    public void gridTesting() {
        Grid tenGrid = new Grid(5,10);
        Grid zeroGrid = new Grid(0,0);
        Grid wonGrid = new Grid(0,5);
        Grid twoGrid = new Grid(0,2);
        String twoGridString = "+--+\n|oo|\n|oo|\n+--+";

        Assertions.assertEquals(5,tenGrid.getNoOfBombs(),"Grid has incorrect number of bombs.");
        Assertions.assertEquals(10,tenGrid.getGridSize(),"Ten grid size is incorrect");
        Assertions.assertEquals(0,zeroGrid.getGridSize(),"Zero grid size is incorrect.");

        tenGrid.checkWin();
        Assertions.assertFalse(tenGrid.gameWon,"Ten grid game is won.");
        wonGrid.checkWin();
        Assertions.assertFalse(wonGrid.gameWon,"Grid with 0 bombs prematurely won.");
        wonGrid.makeMove(3,3);
        Assertions.assertTrue(wonGrid.gameWon,"Grid with 0 bombs not won after first turn.");

        tenGrid.changeTileFlagged(5,5);
        Assertions.assertTrue(tenGrid.tileGrid[5][5].isFlagged(),"Tile at 5,5 not flagged.");
        tenGrid.changeTileFlagged(5,5);
        Assertions.assertFalse(tenGrid.tileGrid[5][5].isFlagged(),"Tile at 5,5 not " +
                "un-flagged again.");

        tenGrid.changeTileFlagged(3,3);
        tenGrid.makeMove(3,3);
        Assertions.assertFalse(tenGrid.tileGrid[3][3].isRevealed(),"Flagged tile can be revealed");
        tenGrid.changeTileFlagged(3,3);
        tenGrid.makeMove(3,3);
        Assertions.assertTrue(tenGrid.tileGrid[3][3].isRevealed(),"Unflagged tile not revealed.");

        Assertions.assertEquals(twoGridString,twoGrid.toString(),"String output for twoGrid not as" +
                " expected");
    }
}
