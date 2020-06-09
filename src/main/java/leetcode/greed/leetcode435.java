package leetcode.greed;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 无重叠区间，这里采用头排序贪心需要额外考虑相同头节点不同尾节点的情况，
 * 而采用尾排序则无需考虑，因为尾排序每次情况已是最优
 */
public class leetcode435 {

    //尾排序，这里记录的是不需要剔除的节点数量
    public int eraseOverlapIntervals_tail(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        //因为循环无法校验参考元素，故默认第一个为合格元素
        int count = 1;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int end = intervals[0][1];
        //循环不检验第一个
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= end){
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    //头排序，记录需要删除的节点数量
    public int eraseOverlapIntervals_head(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        int ans = 0, prev = 0, end = intervals[0][1];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length; i++){
            if (intervals[prev][1] > intervals[i][0]){
                if (intervals[prev][1] > intervals[i][1])
                    prev = i;
                ans++;
            }else {
                prev = i;
            }
        }

        return ans - 1;
    }
}
