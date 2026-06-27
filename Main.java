import java.util.Scanner;
//import java.util.ArrayList;
//import java.lang.Thread;
public class Main {
    public static void main(String[] args) {
        boolean again = true;
        while (again == true){
            boolean gaming = true;
            int turns = 1;
            Game board = new Game();
            int small = 0;
            boolean rules = false;
            boolean mainMenu = true;    
            int large = 0;
            Scanner input = new Scanner(System.in);
            while (mainMenu== true){
                System.out.println("Welcome to Ultimate Tic Tac Toe! \n 1. Play Game \n 2. Rules");
                int answer = input.nextInt();
                System.out.print("\033[H\033[2J");
                while (answer != 1 && answer != 2){
                    System.out.println("Please enter a valid number");
                    System.out.println("Welcome to Ultimate Tic Tac Toe! \n1. Play Game \n2. Rules");
                    answer = input.nextInt();
                    System.out.print("\033[H\033[2J");
                }
                if (answer == 2){
                    rules = true;
                }else{
                    mainMenu = false;
                }
                
                while (rules == true){
                    System.out.println("Ultimate Tic-Tac-Toe is a more advanced version of the two-player board game Tic-Tac-Toe." );
                    System.out.println("\nWinning on a small board is the same as in regular Tic-Tac-Toe. The first player to win a small board wins it. Each small board has either zero or one winner. If a small board is won or full (equivalently, won or drawn), it is closed, and no further moves may be made in it.");
                    System.out.println("\nThe first player may start in any small board.");                   
                    System.out.println("\nMaking a move sends the opponent to the corresponding small board. If that board is closed, the next move can be made in any other open board."); 
                    System.out.println("\nTo win the match, a player must win on the big board by winning three small boards in a line, as if the small boards were the cells in regular Tic-Tac-Toe. If all small boards are closed, and the big board is not won, the match ends in a draw.");
                    System.out.println("\nPress Enter to continue");
                    input.nextLine();
                    input.nextLine();
                    rules = false;
                    System.out.print("\033[H\033[2J");
                }
            }
            boolean boardChoice = true;
            int player = 0;        
            while (gaming == true){
                player = turns%2;
                Game.printBoard();
                while (boardChoice == true){
                    System.out.println("Which Tic Tac Toe Board do want to go in. \n Formatted as \n [1] [2] [3] \n [4] [5] [6] \n [7] [8] [9]");
                    large = input.nextInt();
                    System.out.print("\033[H\033[2J");
                    if(Game.checkFullness(large)){
                        Game.printBoard();
                        System.out.println("That board is full, please choose another one");
                        boardChoice = true;
                    }else{
                        boardChoice = false;
                    }
                }
                Game.printBoard();
                boolean valid = false;
                while (valid == false){
                    System.out.println("You are going in Tic Tac Toe Board " + large);
                    System.out.println("What box do want to go in. \n Formatted as \n [1] [2] [3] \n [4] [5] [6] \n [7] [8] [9]");
                    small = input.nextInt();
                    System.out.print("\033[H\033[2J");
                    valid = Game.move(player,large, small);
                    if (valid == false){
                        Game.printBoard();
                        System.out.println("Place your token in a non filled spot");
                    }
                }
                if (Game.entireWins(player)){
                    System.out.println("Player " + player + " has won the game!");
                    gaming = false;
                }
                large = small;
                if(Game.checkFullness(large)){
                    boardChoice = true;
                }else{
                    boardChoice = false;
                }
                turns++;
            }

        }
        int answer = 0;
        while (answer != 1 && answer !=2){
            System.out.println("Would you like to play again? \n 1. Yes \n 2. No");
            answer = input.nextInt();
            if (answer != 1 && answer != 2){
                System.out.println("Please enter a valid number");
            }
        }
        if (answer == 1){
            again = true;
        }else{
            again = false;
        }
    
    }
}



