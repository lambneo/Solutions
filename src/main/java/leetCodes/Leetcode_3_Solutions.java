package leetCodes;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ziyuy
 * leetcode:第三题，寻找最长子串
 * solution:从第一个元素开始，将元素放入hashmap中，不断向右滑动，若新加入的元素已经存在于hashmap中则清空hashmap开始新的循环
 * note:第一个程序通过两次for循环，算法复杂度极高O(n2)，hashmap方式算法复杂度O(n)
 */

class Leetcode_3_Solutions {


    public static void lengthOfLongestSubstring(String s) {
        int maxlength = 0;
        int startIndex = 0;
        int ans = 0;
        char[] sChar = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = startIndex; j < i; j++) {
                if (sChar[i] == sChar[j]) {
                    startIndex = j + 1;
                    break;
                }
            }
            ans = i - startIndex + 1;
            maxlength = Math.max(maxlength, ans);
        }
        System.out.println(maxlength);


    }

    public static int LengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                j = Math.max(j, map.get(s.charAt(i)));
            ans = Math.max(ans, i - j + 1);
            map.put(s.charAt(i), i + 1);


        }

        return ans;

//		int ans = 0;
//		Map<Character,Integer> map = new HashMap<>();
//		
//		for(int i = 0, j = 0; j < s.length(); j++) {
//			if(map.containsKey(s.charAt(j))) 
//				i = Math.max(map.get(s.charAt(j)),i);
//			ans = Math.max(ans, j - i + 1);
//			map.put(s.charAt(j), j + 1);
//		}
//		System.out.println(ans);

    }


    public static void main(String[] args) {

        String test = "AGDKADGKDADJKIYHA";
        lengthOfLongestSubstring(test);
        System.out.println(LengthOfLongestSubstring(test));


    }
}


