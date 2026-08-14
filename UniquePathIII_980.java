package BackTracking;

public class UniquePathIII_980 {

    public static boolean isValid(int[][] grid, int stIdxR, int stIdxC, int emptyCellCount) {

        // Boundary check
        if (stIdxR < 0 || stIdxC < 0 || stIdxR >= grid.length || stIdxC >= grid[0].length) {
            return false;
        }

        // Obstacle / already visited
        if (grid[stIdxR][stIdxC] == -1) {
            return false;
        }

        // If we reach 2 before visiting all empty cells
        if (grid[stIdxR][stIdxC] == 2 && emptyCellCount != 0) {
            return false;
        }

        return true;
    }

    public static void solve(int[][] grid, int stIdxR, int stIdxC, int[] ans, int emptyCellCount) {

        // We reached the ending point
        if (grid[stIdxR][stIdxC] == 2) {
            if (emptyCellCount == 0) {
                ans[0]++;
            }
            return;
        }

        int[] row = {0, 0, 1, -1};
        int[] col = {1, -1, 0, 0};

        int original = grid[stIdxR][stIdxC];

        // Mark current cell as visited
        grid[stIdxR][stIdxC] = -1;

        for (int i = 0; i < row.length; i++) {

            int newR = stIdxR + row[i];
            int newC = stIdxC + col[i];

            if (isValid(grid, newR, newC, emptyCellCount)) {

                // If next cell is 0, one empty cell is visited
                if (grid[newR][newC] == 0) {
                    solve(grid, newR, newC, ans, emptyCellCount - 1);
                }
                else {
                    // If next cell is 2, don't decrease emptyCell
                    solve(grid, newR, newC, ans, emptyCellCount);
                }
            }
        }

        // Backtracking: restore original value
        grid[stIdxR][stIdxC] = original;
    }

    public static int uniquePathsIII(int[][] grid) {

        int stIdxR = -1;
        int stIdxC = -1;
        int emptyCellCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    stIdxR = i;
                    stIdxC = j;
                }

                if (grid[i][j] == 0) {
                    emptyCellCount++;
                }
            }
        }

        int[] ans = {0};

        solve(grid, stIdxR, stIdxC, ans, emptyCellCount);

        return ans[0];
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        int ans = uniquePathsIII(grid);

        System.out.println(ans);
    }
}