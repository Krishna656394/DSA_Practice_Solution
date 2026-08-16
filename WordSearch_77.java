package BackTracking;

public class WordSearch_77 {
    public static boolean helper(char[][] board,String word, int cr, int cc, int idx){
        if(word.length() == idx){
            return true;
        }
        if(cr < 0 || cc < 0 || cr >= board.length || cc >= board[0].length || word.charAt(idx) != board[cr][cc]){
            return false;
        }

        board[cr][cc] = '*';

        int[] row = {0,0,-1,1};
        int[] col = {-1,1,0,0};
        for(int i = 0; i < row.length; i++){
            if(helper(board, word, cr + row[i], cc + col[i], idx + 1)){
                return true;
            }
        }
        board[cr][cc] = word.charAt(idx);
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                    if(helper(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));

    }
}
