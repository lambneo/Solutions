package leetCodes;

public class Leetcode_11_Solutions {
    public int maxArea(int[] height) {
        int maxarea = (height.length - 1) * Math.min(height[0], height[height.length - 1]);
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length - 1; j++) {

            }

        }
        return 0;
    }

}
