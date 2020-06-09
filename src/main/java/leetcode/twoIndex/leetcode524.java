package leetcode.twoIndex;

import java.util.List;

/**
 * 匹配String
 */
public class leetcode524 {
    public String findLongestWord(String s, List<String> d) {
        int len = 0;
        //注意string不能随便定义为空，空无法调用函数
        String ans = "";
        for (String t : d){
            int len1 = ans.length(), len2 = t.length();
            if (len1 > len2 || (len1 == len2 && ans.compareTo(t) < 0))
                continue;
            if (match(s, t))
                ans = t;
        }
        return ans;
    }

    private boolean match(String s1, String s2){
        int l1 = 0, l2 = 0;
        while (l1 < s1.length() && l2 < s2.length()){
            if(s1.charAt(l1) == s2.charAt(l2)){
                l2++;
            }
            l1++;
        }
        return l2 == s2.length();
    }

}
