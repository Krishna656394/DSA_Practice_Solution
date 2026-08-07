package String;

public class ShuffleString1528 {
    public static String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] letters = new char[n];
        for (int i = 0; i < n; i++){
            letters[indices[i]] = s.charAt(i);
        }
        return new String(letters);
    }
    public static void main(String[] args) {
        String s = "codeleet";
        int[] idx = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString(s,idx));
    }
}
