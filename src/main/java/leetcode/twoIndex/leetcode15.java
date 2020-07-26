package leetcode.twoIndex;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode15，三数之和问题，排序后双指针,需要注意重复问题
 */
public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        if (len == 0 || nums[0] > 0) return ans;

        for(int i = 0; i < len; i++) {
            //这里判断是否重复
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < len; j++) {
                int k = len - 1;
                while (nums[i] + nums[j] + nums[k] > 0 && j < k)
                    k--;
                if (j == k) break;
                if (nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
