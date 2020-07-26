package leetcode.twoIndex;

/**
 * 反转该字符串中的元音字母，双指针解决
 */
public class leetcode345 {
    public String reverseVowels(String s) {
        if (s.length() <= 1) return s;
        int i = 0, j = s.length() - 1;
        char[] t = s.toCharArray();
        while (i < j){
            while (i < j && !isVowel(t[j])) j--;
            while (i < j && !isVowel(t[i])) i++;
            swap(t, i++ , j--);
        }
        return new String(t);
    }

    private boolean isVowel(char ch){
        return ch == 'a'|| ch == 'e'|| ch =='i' || ch =='o'
                || ch =='u'|| ch =='A'|| ch =='E'|| ch =='I'|| ch =='O'|| ch =='U';
    }

    private void swap(char[] chars, int i, int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        leetcode345 test = new leetcode345();
        System.out.println(test.reverseVowels("hello"));
    }

}
