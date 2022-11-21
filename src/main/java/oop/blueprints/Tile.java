package oop.blueprints;

public class Tile {
    private int nearBombs;
    private boolean isBomb;
    private boolean flagged;
    private boolean revealed = false;

    public Tile() {
    }

    public int getNearBombs() {
        return nearBombs;
    }

    public void setNearBombs(int nearBombs) {
        this.nearBombs = nearBombs;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }
}
