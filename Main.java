import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Grid gameGrid = new Grid(10,10);

        launchGame(gameGrid,in);
    }

    public static void launchGame(Grid gameGrid, Scanner input) {
        boolean gameOngoing = true;
        boolean win = false;
        System.out.println(gameGrid);

        while(gameOngoing) {
            if(playerMove(gameGrid,input)) {
                gameGrid.checkWin();
                if(gameGrid.gameWon) {
                    win = true;
                    gameOngoing = false;
                }
            } else {
                win = false;
                gameOngoing = false;
            }
        }

        if(win) {
            System.out.println("Congrats! You won!");
        } else {
            System.out.println("You clicked on a bomb and lost! Loser!");
        }

    }

    public static boolean playerMove(Grid gameGrid, Scanner input) {
        System.out.println("Please enter your move as co-ords x,y,f/t (f means flag/unflag this tile, t means click it):");
        int row;
        int col;
        String flag;
        String[] coOrds = input.nextLine().split(",");

        col = Integer.parseInt(coOrds[0])-1;
        row = Integer.parseInt(coOrds[1])-1;
        flag = coOrds[2];

        if(flag.equals("f")) {
            gameGrid.changeTileFlagged(row,col);
            return true;
        } else {
            if (gameGrid.makeMove(row, col)) {
                return true;
            }
        }

        return false;
    }
}