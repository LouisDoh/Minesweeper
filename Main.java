import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Grid gameGrid = new Grid(10,10);
        System.out.println(gameGrid);
        launchGame(gameGrid,in);
    }

    public static void launchGame(Grid gameGrid, Scanner input) {
        boolean gameOngoing = true;

        while(gameOngoing) {
            if(!playerMove(gameGrid,input)) {
                gameOngoing = false;
            }
        }
        System.out.println(gameGrid);
        System.out.println("You clicked a bomb! Loser!");
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