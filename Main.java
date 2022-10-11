public class Main {
    public static void main(String[] args) {

        Grid gameGrid = new Grid(10,10);
        System.out.println(gameGrid);
        gameGrid.makeMove(0,0);
        System.out.println(gameGrid);
        gameGrid.changeTileFlagged(8,8,true);
        System.out.println(gameGrid);
    }
}