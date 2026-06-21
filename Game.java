public class Game{
    public static String[][][][] board = new String[3][3][3][3];
    public Game(){
        for(int outrow = 0; outrow < 3; outrow++){
            for (int inrow = 0; inrow < 3; inrow++){
                for (int outCol = 0; outCol < 3; outCol++){
                    for (int inCol = 0; inCol < 3; inCol++){
                        board[outrow][inrow][outCol][inCol] = " - ";
                    }
                }
            }
        }
    }
    public static void printBoard(){
        int outrow = 0;
        for (outrow = 0; outrow<3; outrow++){
            for (int inrow = 0; inrow <board[0][0].length; inrow++){
                for (int outcol = 0; outcol< board[0].length;outcol++){
                    for(int incol = 0; incol < board[0][0][0].length; incol++){
                        System.out.print(board[outrow][outcol][inrow][incol]);
                        if(incol<2){
                            System.out.print("|");
                        }
                    }
                    if (outcol<2){
                        System.out.print("  |  ");
                    }
                }
                System.out.println();
                if (inrow < 2){
                    System.out.print("───────────  |  ───────────  |  ───────────");
                    System.out.println();
                }
            }
            if (outrow<2){
                System.out.print("───────────────────────────────────────────");
            }
            System.out.println();
        }
    }
}