package BackTracking;
import java.util.*;
public class CombinationProblem77 {
    public static void solve(int n, int k, List<Integer> res, List<List<Integer>> ans, int idx){
        if(k == res.size()){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = idx; i < n; i++){
                res.add(i+1);
                solve(n, k, res, ans, i + 1);
                res.removeLast();
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        solve(n, k, res, ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
//        solve(num, n, k, "", 0, 0);
        List<List<Integer>> ans = combine(n, k);
        System.out.println(ans);

    }
}
