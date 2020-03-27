package leetCodes;

/**
 * @author ziyuy
 * 要熟悉使用String的一些内置方法，比如indexof或者substring
 */
public class Leetcode_14_Solutions {
    public String longestCommonPrefix(String[] strs) {
        String prefix;
        if (strs.length == 0) return "";
        prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

}
