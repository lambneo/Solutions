package leetCodes;


import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌顺子问题
 */
public class Interview61 {
    public boolean isStraight(int[] nums) {
        int max = 1, min = 14;
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            if (i != 0){
                if (set.add(i)){
                    max = Math.max(i, max);
                    min = Math.min(i, min);
                }else
                    return false;
            }
        }
        if (max - min < 5)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Interview61 solo = new Interview61();
        System.out.print(solo.isStraight(new int[]{1,2,0,2,6}));
    }
}
