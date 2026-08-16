package BackTracking;

public class IsLandCount {
    public static int count = 0;
    public static void solve(char[][] grid, int sr, int sc){
        if(sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length){
            return;
        }
        if(grid[sr][sc] == '0'){
            return;
        }
        grid[sr][sc] = '0';
        int[] row = {0,0,1,-1};
        int[] col = {1,-1,0,0};
        for(int i = 0; i < row.length; i++){
            solve(grid, sr+row[i], sc + col[i]);
        }

    }
    public static int numIslands(char[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    solve(grid, i, j);
                }

            }
        }

        return count;
    }
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        int ans = numIslands(grid);
        System.out.println("Number of Island = "+ans);

    }
}
