package swd2offer;

import java.util.Arrays;

/**
 * 自定义排序
 */
public class Interview45 {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            StringBuilder res = new StringBuilder();
            sort(strs, 0 , nums.length - 1);
            for (String s : strs)
                res.append(s);
            return res.toString();
        }

        private void sort(String[] str, int l, int r){
            if (l >= r) return;
            int i = l, j = r;
            String tmp = str[i];
            while (i < j){
                while ((str[j] + str[l]).compareTo(str[l] + str[j]) >= 0 && i < j) j--;
                while ((str[i] + str[l]).compareTo(str[l] + str[i]) <= 0 && i < j) i++;
                tmp = str[i];
                str[i] = str[j];
                str[j] = tmp;
            }
            str[j] = str[l];
            str[l] = tmp;
            sort(str, l, j - 1);
            sort(str, j + 1, r);
        }


    public String minNumber_innerFunc(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }


}
