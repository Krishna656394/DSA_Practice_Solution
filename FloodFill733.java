package BackTracking;

public class FloodFill733 {
    public static void solve(int[][] image, int sr, int sc, int color, int oldColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length){
            return;
        }
        if(image[sr][sc] != oldColor)
            return;
        image[sr][sc] = color;
        int[] row = {0,0,1,-1};
        int[] col = {1,-1,0,0};
        for(int i = 0; i < row.length; i++){
            solve(image, sr+row[i], sc + col[i], color, oldColor);
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor == color)
            return image;
        solve(image, sr, sc, color, oldColor);
        return image;
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,1}, {1,1,0},{1,0,1}};
        int color = 2;
        int sr = 1;
        int sc = 1;
        int[][] ans = floodFill(image, sr, sc, color);
        for(int[] arr : ans){
            for (int col : arr){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
