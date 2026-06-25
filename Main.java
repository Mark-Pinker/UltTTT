import java.util.Scanner;
//import java.util.ArrayList;
//import java.lang.Thread;
public class Main {
    public static void main(String[] args) {
        boolean gaming = true;
        int turns = 1;
        Game board = new Game();
        int small = 0;
        int large = 0;
        System.out.println("Welcome to Ultimate Tic Tac Toe!");
        boolean boardChoice = true;
        int player = 0;
        Scanner input = new Scanner(System.in);
        
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
}



