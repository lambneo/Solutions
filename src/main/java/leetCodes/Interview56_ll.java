package leetCodes;

import java.util.HashMap;
import java.util.Map;

public class Interview56_ll {
    public int singleNumber(int[] nums) {
        int res = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums){
            if (!map.containsKey(i)) map.put(i, true);
            else map.put(i, false);
        }

        for (int i : nums){
            if (map.get(i))
               res = i;
        }
        return res;
    }
}
