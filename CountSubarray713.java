package SlidingWindow;

public class CountSubarray713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int startWindow = 0;
        int ans = 0;
        int p = 1;
        int i = 0;
        while(i < nums.length){
            // Growing
            p *= nums[i];

            // Shirinking
            while(p >= k && startWindow <= i){
                p = p / nums[startWindow];
                startWindow++;
            }
            // answer Updating
            ans = ans + (i - startWindow + 1);
            i++;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 10;

        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
