package TwoPointer_Problem;

public class ContainerMostWater11 {
    public static int maxArea(int[] height) {
        int low = 0;
        int high = height.length-1;
        int width = 0;
        int maxArea = 0;
        while (low <= high){
            width = high - low;
            int area;
            if(height[low] < height[high]){
                area = width * height[low];
                maxArea = Math.max(maxArea, area);
                low++;
            }
            else {
                area = width * height[high];
                maxArea = Math.max(maxArea, area);
                high--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int water = maxArea(height);
        System.out.println("Max Water = "+water);
    }
}
