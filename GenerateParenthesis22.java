package Recursion_Concept;
import java.util.*;
public class GenerateParenthesis22 {
    public static void solve(int n, List<String> ans, String comb, int open, int close){
        if(open == n && close == n){
            ans.add(comb);
            return;
        }
        if(open < n){
            solve(n, ans, comb +"(", open + 1, close);
        }
        if (close < open)
            solve(n, ans, comb +")", open, close + 1);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, ans, "", 0, 0);
        return ans;
    }
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result);

    }
}
