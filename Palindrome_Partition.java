package BackTracking;

public class Palindrome_Partition {
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
    public static void partation(String s, String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        for(int i = 1; i <= s.length(); i++){
            String part = s.substring(0,i);
            if(isPalindrome(part)){
                partation(s.substring(i), ans + part+"|");
            }
        }
    }
    public static void main(String[] args) {
        String s = "NITIN";
        partation(s, "");
    }
}
