package leetCodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最长公共子串
 */
public class Interview48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int head = 0, tail = 0, n = str.length, ans = 1;
        while (tail < n){
            if (map.containsKey(str[tail])){
                //用最大值确定当前head索引
               head = Math.max(head, map.get(str[tail]) + 1);
                map.put(str[tail], tail);
            }
            ans = Math.max(ans, tail - head + 1);
            map.put(str[tail], tail++);
        }
        return ans;
    }

    public static void main(String[] args) {
        Interview48 test = new Interview48();
        System.out.println(test.lengthOfLongestSubstring("tmmzuxt"));
    }
}
