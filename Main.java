import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        Grid gameGrid = new Grid(4,4);*/

        launchGame();
    }

    public static void launchGame() {
        Scanner in = new Scanner(System.in);
        Grid gameGrid;
        boolean playAgain = true;
        boolean gameOngoing;
        boolean win;
        int gridSize;
        int noOfBombs;

        while(playAgain) {
            System.out.println("How big would you like your grid?");
            gridSize = in.nextInt();
            System.out.println("And how many bombs do you want?");
            noOfBombs = in.nextInt();
            in.nextLine(); //clean input stream

            gameGrid = new Grid(noOfBombs,gridSize);
            gameOngoing = true;
            win = false;
            System.out.println(gameGrid);

            while(gameOngoing) {
                if(playerMove(gameGrid,in)) {
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
            System.out.println("Would you like to play again (y/n)?");
            if(in.next().equals("n")) {
                playAgain = false;
            }
            in.nextLine(); //clean the input stream
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