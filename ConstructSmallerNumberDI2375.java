package StackDataStructure;

import java.util.Arrays;
import java.util.Stack;

public class ConstructSmallerNumberDI2375 {
    public static String smallestNumber(String pattern) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[pattern.length() + 1];
        int j = 1;
        for(int i = 0; i <= pattern.length(); i++){
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                ans[i] = j++;
                while (!st.isEmpty()){
                    ans[st.pop()] = j++;
                }
            }
            else {
                st.push(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for(int val : ans)
            res.append(val);
        return res.toString();
    }

//    More Optimal Solution...
    public static String smallestNum(String pattern){
        int[] ans = new int[pattern.length() + 1];
        int j = 1;
        for(int i = 0; i <= pattern.length(); i++){
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                ans[i] = j++;
                int k = i - 1;
                for(; k >= 0; k--){
                    if(ans[k] != 0)
                        break;
                    else ans[k] = j++;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int val : ans)
            res.append(val);
        return res.toString();
    }
    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        System.out.println(smallestNumber(pattern));
        System.out.println(smallestNum(pattern));
    }
}
