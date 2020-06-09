package leetcode;

/**
 * 盛水最多的容器,可知移动短板的情况
 */
public class leetcode11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while (l < r) {
            max = height[l] < height[r] ?
                    Math.max(max, (r - l) * height[l]):
                    Math.max(max, (r - l) * height[r]);
        }
        return max;
    }

}
