package leetCodes;


import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 */
public class Interview50 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<Character, Boolean>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        for (int i = 0; i < s.length(); i++){
            if (map.get(s.charAt(i)))
                return s.charAt(i);
        }
        return ' ';
    }
}
