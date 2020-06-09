package leetcode.greed;

import java.util.Arrays;

//贪心，排序后双指针，最后返回小孩指针位置即可
public class leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length){
            if (g[gi] < s[si])
                gi++;
            si++;
        }
        return gi;
    }
}
