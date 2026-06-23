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
        
        while (gaming = true){
            player = turns%2;
            Game.printBoard();
            if(boardChoice == true){
                System.out.println("Which Tic Tac Toe Board do want to go in. \n Formatted as \n [1] [2] [3] \n [4] [5] [6] \n [7] [8] [9]");
                large = input.nextInt();
                System.out.print("\033[H\033[2J");
            }
            System.out.println("You are going in Tic Tac Toe Board " + large);
            Game.printBoard();
            System.out.println("What box do want to go in. \n Formatted as \n [1] [2] [3] \n [4] [5] [6] \n [7] [8] [9]");
            small = input.nextInt();
            System.out.print("\033[H\033[2J");
            Game.move(player,large, small);
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



