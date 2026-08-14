package BackTracking;

public class N_Queen_All_Possible {
    public static void display(boolean[][] board){
        System.out.println(".........Queen Placed........");
        for(boolean[] row : board){
            for(boolean flag : row){
                System.out.print(flag+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isSafe(boolean[][] board, int row, int col){

        int r = row;
        int c = col;
        //Check UpWard Direction.
        while (r >= 0){
            if(board[r][c])
                return false;
            r--;
        }
        r = row;
        //Check Left Diagonal
        while (r >= 0 && c >= 0){
            if(board[r][c])
                return false;
            r--;
            c--;
        }
        r = row;
        c = col;

        //Check Right Diagonal.
        while (r >= 0 && c < board[0].length){
            if(board[r][c])
                return false;
            r--;
            c++;
        }
        return true;
    }
    public static void placeQueen(boolean[][] board, int row, int tq){
        if(tq == 0){
            display(board);
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                placeQueen(board, row+1, tq - 1);
                board[row][col] = false;
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        placeQueen(board, 0,n);
    }
}
