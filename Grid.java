import java.util.Random;

public class Grid {

    private Tile[][] tileGrid;
    private int gridSize;
    private int numberOfBombs;

    public Grid(int numberOfBombs, int gridSize) {
        this.tileGrid = new Tile[gridSize][gridSize];
        this.gridSize = gridSize;

        for(int row=0; row<gridSize; row++) {
            for(int col=0; col<gridSize; col++) {
                this.tileGrid[row][col] = new Tile();
            }
        }

        Random random = new Random();

        for(int i=0; i<numberOfBombs; i++) {
            int row = random.nextInt(gridSize);
            int col = random.nextInt(gridSize);

            while(this.tileGrid[row][col].isBomb()) {
                row = random.nextInt(gridSize);
                col = random.nextInt(gridSize);
            }
            this.tileGrid[row][col].setBomb(true);
        }

        for()

    }

    private int surroundingBombs(int tileRow,int tileCol) {
        int nearbyBombs = 0;

        for(int row=tileRow-1;row<tileRow+1;row++) {
            for(int col=tileCol-1;col<tileCol+1;col++) {
                if ((row>0 && row<gridSize) && (col>0 && col<gridSize)) {
                    if this.tileGrid()
                }
            }
        }
    }

    public String toString() {
        String returnString = "*";
        for(int i=0; i<this.gridSize; i++) {
            returnString += "-";
        }
        returnString += "*\n";

        for(Tile[] row : this.tileGrid) {
            returnString += "|";
            for(Tile tile : row) {
                if(tile.isRevealed()) {
                    if(tile.getNearBombs() == 0) {
                        returnString += " ";
                    } else {
                        returnString += tile.getNearBombs();
                    }

                } else if(tile.isFlagged()){
                    returnString += "!";

                } else {
                    returnString += "o";
                }
            }
            returnString += "|\n";
        }
        returnString += "*";
        for(int i=0; i<this.gridSize; i++) {
            returnString += "-";
        }
        returnString += "*";

        return returnString;
    }

}
