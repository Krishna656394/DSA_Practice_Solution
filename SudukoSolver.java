package BackTracking;

public class SudukoSolver {
    public static boolean isValid(int[][] board, int row, int col, int val){
        //Row Checking....
        for(int c = 0; c < 9; c++){
            if(board[row][c] == val)
                return false;
        }
        //Column Checking....
        for(int r = 0; r < 9; r++){
            if(board[r][col] == val)
                return false;
        }

        // Matrix Checking
        int r = row - row % 3;
        int c = col - col % 3;
        for(int i = r; i < r + 3; i++){
            for(int j = c; j < c + 3; j++){
                if(board[i][j] == val)
                    return false;
            }
        }
        return true;
    }
    public static void display(int[][] board){
        for(int[] row : board){
            for(int val : row){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    public static void solve(int[][] board, int cr, int cc){
        if(cc == 9){
            cc = 0;
            cr++;
        }
        if(cr == 9){
            display(board);
            return;
        }
        if(board[cr][cc] != 0)
            solve(board, cr, cc + 1);
        else {
            for(int val = 1; val <= 9; val++){
                if(isValid(board, cr, cc, val)){
                    board[cr][cc] = val;
                    solve(board, cr, cc+1);
                    board[cr][cc] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        solve(board, 0, 0);
    }
}
