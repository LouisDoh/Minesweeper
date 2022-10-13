import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        String againInput;
        boolean askingForAgain;

        while(playAgain) {
            System.out.println("How big would you like your grid?");
            while(!in.hasNextInt()) {
                System.out.println("Please only input a single number. How big would you like your grid?");
                in.next(); //swallow garbage input
            }
            gridSize = in.nextInt();

            System.out.println("And how many bombs do you want?");
            while(!in.hasNextInt()) {
                System.out.println("Please only input a single number. How many bombs do you want?");
                in.next();
            }

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
                    gameOngoing = false;
                }
            }

            if(win) {
                System.out.println("Congrats! You won!");
            } else {
                System.out.println("You clicked on a bomb and lost! Loser!");
            }
            System.out.println("Would you like to play again (y/n)?");
            askingForAgain = true;

            while(askingForAgain) {
                againInput = in.next();
                if(againInput.equals("n")) {
                    playAgain = false;
                    askingForAgain = false;
                } else if(!againInput.equals("y")) {
                    System.out.println("Please only input a single letter, y or n:");
                } else {
                    askingForAgain = false;
                }
            }

            in.nextLine(); //clean the input stream
        }


    }

    public static boolean playerMove(Grid gameGrid, Scanner input) {
        int row;
        int col;
        String flag;

        while(true) { //return statements will exit out of method where needed
            System.out.println("Please enter your move as co-ords x,y,f/t (f means flag/unflag this tile, t means click it):");
            String[] coOrds = input.nextLine().split(",");
            if (coOrds.length == 3) {

                try {
                    col = Integer.parseInt(coOrds[0])-1;
                    row = Integer.parseInt(coOrds[1])-1;
                    flag = coOrds[2];

                    if(flag.equals("f")) {
                        gameGrid.changeTileFlagged(row,col);
                        return true;
                    } else if(flag.equals("t")){
                        return gameGrid.makeMove(row, col);
                    } else {
                        System.out.println("You need to give either an 'f' or a 't' as your third input.");
                    }

                } catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Wrong inputs! Double check your co-ordinates are integers and make sure they're in-bounds.");
                }

            } else {
                System.out.println("Wrong number of inputs!");
            }

        }
    }
}