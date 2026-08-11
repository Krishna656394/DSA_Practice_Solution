package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Coin_Picking {
    // Permutation ...............

    public static void coinPermutation(int[] coins, int amount, int coinSum, String ans){
        if(amount == coinSum){
            System.out.println(ans);
            return;
        }
        if(coinSum <= amount){
            for(int i = 0; i < coins.length; i++){
                coinPermutation(coins, amount, coinSum + coins[i], ans + coins[i]);
            }
        }
    }

    public static void pickCoin(int[] coins, int amt, String ans){
        if(amt == 0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < coins.length; i++){
            if(amt >= 0){
//                amt -= coins[i]; if i can do this then i can change original value
//                Then backtracking is used.
                pickCoin(coins, amt - coins[i], ans + coins[i]);// i can only change argument
//              amt += coins[i] if i can used backtrack...
            }
        }
    }

    // Find Combination ...

    public static void pickCoinComb(int[] coins, int amt, List<Integer> ans, int idx, List<List<Integer>> res){
        if(amt == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = idx; i < coins.length; i++){
            if(amt >= 0){
                ans.add(coins[i]);
                pickCoinComb(coins, amt - coins[i], ans, i, res);
                ans.removeLast();
            }
        }
    }

    //Same as Leetcode 39.
    public static List<List<Integer>> solve(int[] coins, int amt){
        List<List<Integer>> result = new ArrayList<>();
        pickCoinComb(coins, amt,new ArrayList<>(), 0, result);
        return result;
    }
    public static void main(String[] args) {
        int[] coins = {2, 1, 3};
        int amount = 4;
        System.out.println("Permutation of Coin.....:");
        coinPermutation(coins, amount,0, "");
//      Another Method....
        System.out.println("Another Way ............");
        pickCoin(coins, amount, "");

        System.out.println("Combination of Coin......: ");
        List<List<Integer>> res = solve(coins, amount);
        System.out.println(res);





    }
}
