package SlidingWindow;

public class MinimumLengthSubarraySumK209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int startWindow = 0;
        int minLen = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        while (i < nums.length){
            //Growing
            sum += nums[i];
            //shrinking

            while (sum >= target && startWindow <= i){
                int len = i - startWindow + 1;
                minLen = Math.min(minLen, len);
                sum -= nums[startWindow];
                startWindow++;
            }
            i++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
