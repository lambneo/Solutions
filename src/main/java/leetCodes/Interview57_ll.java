package leetCodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 和为s的连续正数序列
 */
public class Interview57_ll {
    public int[][] findContinuousSequence(int target) {

        List<int[]> res = new ArrayList<>();

        for (int i = 2; i < target/2; i++){
            //偶数
            if ((target % i == i/2) && (target/i - i/2 + 1> 0 ) && (i % 2 == 0)){
                int[] ans = new int[i];
                for (int j = 0; j < i; j++)
                    ans[j] = target/i - i/2 + 1 + j;
                res.add(ans);
            }

            //奇数
            if ((target % i == 0) && (target/i - i/2 > 0 ) && (i % 2 == 1)){
                int[] ans = new int[i];
                for (int j = 0; j < i; j++)
                    ans[j] = target/i - i/2 + j;
                res.add(ans);
            }
        }
        Collections.reverse(res);
        return res.toArray(new int[0][]);
    }
}
