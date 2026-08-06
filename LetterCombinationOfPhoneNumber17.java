package Recursion_Concept;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber17 {
    public static void solve(int idx, String curr, List<String> ans, String digits, String[] keypad){
        if(digits.length() == idx){
            ans.add(curr);
            return;
        }
        String currLetter = keypad[digits.charAt(idx) - '0'];
        for(int i = 0; i < currLetter.length(); i++){
            char ch = currLetter.charAt(i);
            solve(idx+1, curr+ch, ans, digits, keypad);
        }
    }

    public static List<String> letterCombinations(String digits) {
        String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        solve(0, "", ans, digits, keypad);

        return ans;
    }
    public static void main(String[] args) {
        String s = "23";
        List<String> ans = letterCombinations(s);
        System.out.println(ans);
    }
}
