package SlidingWindow;

public class CountNoOfNiceSubarray1248 {
    public static int numberOfSubarrays(int[] nums, int k) {
        int startWindow = 0;
        int endWindow = 0;
        int oddCount = 0;
        int ans = 0;
        while (endWindow < nums.length){
            // Growing
            if(nums[endWindow] % 2 != 0)
                oddCount++;
            //Shirking
            while (oddCount > k){
                if(nums[startWindow] % 2 != 0){
                    oddCount--;
                }
                startWindow++;
            }

            //Answer Update
            ans += endWindow - startWindow + 1;

            endWindow++;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] arg) {
        int[] nums = {1,1,2,1,1};
        int k = 3;

        int result1 = numberOfSubarrays(nums, k);
        int result2 = numberOfSubarrays(nums, k-1);
        int result = result1 - result2;
        System.out.println(result);
    }
}
