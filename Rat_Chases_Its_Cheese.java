package BackTracking;

import java.util.Scanner;

public class Rat_Chases_Its_Cheese {
    public static boolean flag = false;
    public static void display(int[][] ans){
        for(int[] num : ans){
            for(int val : num){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    public static void ratInMaze(char[][] maze, int cr, int cc, int[][] ans){
        if(cr == maze.length-1 && cc == maze[0].length-1 && maze[cr][cc] != 'X'){
            ans[cr][cc] = 1;
            flag = true;
            display(ans);
            return;
        }
        if(cr < 0 || cc < 0 || cr >= maze.length || cc >= maze[0].length || maze[cr][cc] == 'X'){
            return;
        }
        maze[cr][cc] = 'X';
        ans[cr][cc] = 1;
        int[] row = {0, 0, -1, 1};// if u move diagonal the add condition in both array.
        int[] col = {1, -1, 0, 0};
        for(int i = 0; i < row.length; i++){
            ratInMaze(maze, cr + row[i], cc + col[i], ans);// this one line move all four direction.
        }
//        ratInMaze(maze, cr, cc+1, ans); // Left Move
//        ratInMaze(maze, cr, cc-1, ans); // Right Move
//        ratInMaze(maze, cr-1, cc, ans); // Up Move
//        ratInMaze(maze, cr+1, cc, ans); // Down Move
        maze[cr][cc] = 'O';
        ans[cr][cc] = 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] maze = new char[n][m];
        for (int i = 0; i < maze.length; i++){
            String s = sc.next();
            for (int j = 0; j < s.length(); j++){
                maze[i][j] = s.charAt(j);
            }
        }

        int[][] ans = new int[n][m];
        ratInMaze(maze, 0, 0, ans);
        if(!flag){
            System.out.println("No Path Found");
        }
    }
}
