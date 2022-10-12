import java.util.Random;

public class Grid {

    public Tile[][] tileGrid; //Remember to make this priv again
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
            int row = random.nextInt(gridSize-1);
            int col = random.nextInt(gridSize-1);

            while(this.tileGrid[row][col].isBomb()) {
                row = random.nextInt(gridSize);
                col = random.nextInt(gridSize);
            }
            this.tileGrid[row][col].setBomb(true);
        }
        updateNearbyBombs();
    }

    public boolean makeMove(int moveRow, int moveCol) {
        this.tileGrid[moveRow][moveCol].setRevealed(true);
        if(this.tileGrid[moveRow][moveCol].getNearBombs() == 0) {
            revealZeroes(moveRow,moveCol);
        }

        if(this.tileGrid[moveRow][moveCol].isBomb()) {
            return false;
        }

        System.out.println(this);
        return true;
    }

    public void changeTileFlagged(int flagRow, int flagCol) {
        boolean inverted = !this.tileGrid[flagRow][flagCol].isFlagged();
        this.tileGrid[flagRow][flagCol].setFlagged(inverted);
    }

    private void revealZeroes(int zeroRow, int zeroCol) {
        this.tileGrid[zeroRow][zeroCol].setRevealed(true);
        for(int row=zeroRow-1; row<=zeroRow+1; row++) {
            if(row>=0 && row<this.gridSize) {
                for(int col=zeroCol-1; col<=zeroCol+1; col++) {
                    if(col>=0 && col<this.gridSize) {
                        if(!this.tileGrid[row][col].isRevealed() &&
                                this.tileGrid[row][col].getNearBombs() == 0) {
                            revealZeroes(row,col);
                        } else {
                            this.tileGrid[row][col].setRevealed(true);
                        }
                    }
                }
            }
        }
    }

    public void updateNearbyBombs() {
        for(int row=0; row<gridSize; row++) {
            for(int col=0; col<gridSize; col++) {
                int nearBombs = this.surroundingBombs(row,col);
                this.tileGrid[row][col].setNearBombs(nearBombs);
            }
        }
    }

    private int surroundingBombs(int tileRow, int tileCol) {
        int nearbyBombs = 0;

        for(int row=tileRow-1; row<=tileRow+1; row++) {
            if(row>=0 && row<this.gridSize) {
                for(int col=tileCol-1; col<=tileCol+1; col++) {
                    if(col>=0 && col<this.gridSize) {
                        if(this.tileGrid[row][col].isBomb()) {
                            nearbyBombs++;
                        }
                    }
                }
            }
        }

        return nearbyBombs;
    }

    public String toString() {
        String returnString = "+";
        for(int i=0; i<this.gridSize; i++) {
            returnString += "-";
        }
        returnString += "+\n";

        for(Tile[] row : this.tileGrid) {
            returnString += "|";
            for(Tile tile : row) {
                if(tile.isRevealed()) {
                    if(tile.isBomb()) {
                        returnString += "B";
                    } else if(tile.getNearBombs() == 0) {
                        returnString += ".";
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
        returnString += "+";
        for(int i=0; i<this.gridSize; i++) {
            returnString += "-";
        }
        returnString += "+";

        return returnString;
    }

}
