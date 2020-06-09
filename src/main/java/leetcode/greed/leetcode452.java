package leetcode.greed;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) return points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int tail = points[0][1], cnt = 1;
        for (int i = 1; i < points.length; i++){
            if (points[i][0] <= tail){
                continue;
            }
            cnt++;
            tail = points[i][1];
        }
        return cnt;

    }
}
