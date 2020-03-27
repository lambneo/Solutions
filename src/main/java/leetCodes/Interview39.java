package leetCodes;

public class Interview39 {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int ans = 0;
        for (int i : nums){
            if (vote == 0) ans = i;
            vote += ans == i? 1 : -1;
        }
        return ans;
    }
}
