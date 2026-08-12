package BackTracking;
import java.util.*;

public class PalindromePartationLeetCode131 {
    public static boolean isPalindrome(String s){
        int l = 0;
        int h = s.length()-1;
        while (l <= h){
            if(s.charAt(l) != s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
    public static void solve(String s, List<String> ans, List<List<String>> result){
        if(s.isEmpty()){
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 1; i <= s.length(); i++){
            String part = s.substring(0, i);
            if(isPalindrome(part)){
                ans.add(part);
                solve(s.substring(i), ans, result);
                ans.removeLast();
            }
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(s, ans, result);
        return result;
    }
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = partition(s);
        System.out.println(ans);
    }
}
