package Two2D_Array;

import java.util.Scanner;

public class Search2DMatrix240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int i = 0;
        int j = c-1;
        while(i < r && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = sc.nextInt();
        System.out.println(searchMatrix(matrix, target));
        sc.close();

    }
}
