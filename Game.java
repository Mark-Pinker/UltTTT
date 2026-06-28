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
    public static boolean move(int player,int large, int small){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String text = "  ";
        int sRow = 0;
        int sCol = 0;
        int lRow = 0;
        int lCol = 0;
        if (large <= 3){
            lRow = 0;
        }else if(large > 6){
            lRow = 2;
        }else{
            lRow = 1;
        }
       lCol = (large%3)-1;
       if (lCol == -1){
            lCol = 2;
       }
        
        if (small <= 3){
            sRow = 0;
        }else if(small > 6){
            sRow = 2;
        }else{
            sRow = 1;
        }
        sCol = (small%3)-1;
        if (sCol == -1){
            sCol = 2;
        }
        if (player ==1){
            text = " x ";
        }else{
            text = " o ";
        }
        if (board[lRow][lCol][sRow][sCol].equals(" - ")){
            board[lRow][lCol][sRow][sCol] = text;
            return true;
        }

        return false;
    }
    public static boolean checkFullness(int large){
        int lRow = 0;
        int lCol = 0;
        if (large <= 3){
            lRow = 0;
        }else if(large > 6){
            lRow = 2;
        }else{
            lRow = 1;
        }
       lCol = (large%3)-1;
       if (lCol == -1){
            lCol = 2;
       }
        String check = board[lRow][lCol][0][0];
        for (int outer = 0; outer <= 2;outer++){
            for(int inner = 0; inner <= 2; inner++){
                if (board[lRow][lCol][outer][inner].equals(" - ")){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean smallWins(int player, int outRow, int outCol){
        String text = " - ";
        if (player == 1){
            text = " x ";
        }else{
            text = " o ";    
        }
        boolean win = false;
        for (int inRow = 0; inRow < 3; inRow++){
            int count = 0;
            for (int inCol = 0; inCol < 3; inCol++){
                if(board[outRow][outCol][inRow][inCol].equals(text)){
                    count++;
                }else{
                    count = 0;
                }
                if (count>=3){
                    win = true;
                }
            }
        }
        for (int inCol = 0; inCol < 3; inCol++){
            int count = 0;
            for (int inRow = 0; inRow < 3; inRow++){
                if(board[outRow][outCol][inRow][inCol].equals(text)){
                    count++;
                }else{
                    count = 0;
                }
                if (count>=3){
                    win = true;
                }
            }
        }
        if (board[outRow][outCol][2][2].equals(text) && board[outRow][outCol][1][1].equals(text) && board[outRow][outCol][0][0].equals(text)){
            win = true;
        }
        if (board[outRow][outCol][2][0].equals(text) && board[outRow][outCol][1][1].equals(text) && board[outRow][outCol][0][2].equals(text)){
            win = true;
        }
        if (win == true){
                for (int sRow = 0; sRow < 3; sRow++){
                    for (int sCol = 0; sCol < 3; sCol++){
                        board[outRow][outCol][sRow][sCol] = text;
                    }
                }
            return true;
        }
        return false;
    }
    public static boolean entireWins(int player){
        String text;
        if (player == 1){
            text = " x ";
        }else{
            text = " o ";    
        }
        for (int lRow = 0; lRow < 3; lRow++){
            int count = 0;
            for (int lCol = 0; lCol < 3; lCol++){
                if(smallWins(player,lRow,lCol)){
                    count++;
                }else{
                    count = 0;
                }
                if (count>=3){
                    return true;
                }
            }
        }
        for (int lCol = 0; lCol < 3; lCol++){
            int count = 0;
            for (int lRow = 0; lRow < 3; lRow++){
                if(smallWins(player,lRow,lCol)){
                    count++;
                }else{
                    count = 0;
                }
                if (count>=3){
                    return true;
                }
            }
        }
        if (smallWins(player, 0,0) && smallWins(player,1,1) && smallWins(player,2,2)){
            return true;
        }
        if (smallWins(player, 0,2) && smallWins(player,1,1) && smallWins(player,2,0)){
            return true;
        }
        return false;
    }
}