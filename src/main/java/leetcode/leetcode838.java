package leetcode;


import java.util.HashMap;
import java.util.Map;


/**
 * @author ziyuy
 * 多米诺骨牌问题，自己写的就是不完全的动态规划
 */
public class leetcode838 {
    public static String pushDominoes(String dominoes) {
        int StartIndex = dominoes.length();
        int EndIndex = 0;
        int count = 0;
        char[] sChar = dominoes.toCharArray();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(0, 0);

        for (int i = 0; i < dominoes.length(); i++) {
            if (sChar[i] == 'R')
                StartIndex = i;

            if (sChar[i] == 'L')
                EndIndex = i;

            if (EndIndex > StartIndex) {
                int len = EndIndex - StartIndex + 1;
                count++;
                map1.put(count, StartIndex);
                map2.put(count, EndIndex);
                for (int j = map1.get(count); j >= map2.get(count - 1); j--) {
                    if (sChar[j] == 'L') {
                        for (int k = j; k >= map2.get(count - 1); k--) {
                            sChar[k] = 'L';
                        }
                    }
                    if (sChar[j] == 'R') {
                        for (int k = j; k <= map1.get(count); k++) {
                            sChar[k] = 'R';
                        }
                    }
                }
                if (len % 2 == 1) {
                    int balancedIndex = StartIndex + len / 2;
                    sChar[balancedIndex] = '.';
                    for (int j = StartIndex; j < balancedIndex; j++) {
                        sChar[j] = 'R';
                    }
                    for (int j = balancedIndex + 1; j <= EndIndex; j++) {
                        sChar[j] = 'L';
                    }
                } else {
                    for (int j = StartIndex; j <= StartIndex + len / 2 - 1; j++) {
                        sChar[j] = 'R';
                    }
                    for (int j = EndIndex - len / 2 + 1; j <= EndIndex; j++) {
                        sChar[j] = 'L';
                    }
                }
                StartIndex = dominoes.length();
                EndIndex = 0;
            }
        }
        if (map2.get(map2.size() - 1) < dominoes.length()) {
            for (int j = map2.get(map2.size() - 1) + 1; j < dominoes.length(); j++) {
                if (sChar[j] == 'R') {
                    for (int k = j; k < dominoes.length(); k++) {
                        sChar[k] = 'R';
                    }
                }
                if (sChar[j] == 'L') {
                    for (int k = j; k >= map2.get(map2.size() - 1); k--) {
                        sChar[k] = 'L';
                    }
                }
            }
        }

        if (count == 0) {
            for (int j = dominoes.length() - 1; j >= 0; j--) {
                if (sChar[j] == 'R') {
                    for (int k = j; k < dominoes.length(); k++) {
                        sChar[k] = 'R';
                    }
                }

                if (sChar[j] == 'L') {
                    for (int k = j; k >= 0; k--) {
                        sChar[k] = 'L';
                    }
                }
            }
        }
        dominoes = String.valueOf(sChar);
        return dominoes;


    }

    public static void main(String[] args) {
        String s = "L.....RR.RL.....L.R.";
        System.out.print(pushDominoes(s));

    }

    /**
     * 2019/05/16
     * 评论中的较好答案，尚未看懂
     */
    public String pushDominoesExampleAnswer(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        int leftIdx = -1, rightIdx = -1; // 最大的L和R下标
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == 'L') {
                if (leftIdx > rightIdx || rightIdx == -1) {
                    // L指针最大, 把上一个L指针到当前节点全部置为L
                    setChar(sb, leftIdx + 1, i - 1, 'L');
                } else {
                    // R指针最大，如果当前index和最近的R之差可以被2整除，那么中间节点应该为'.'
                    int gap = i - rightIdx;
                    if (gap % 2 == 0) {
                        sb.setCharAt(rightIdx + gap / 2, '.');
                    }
                    setChar(sb, rightIdx + gap / 2 + 1, i - 1, 'L');
                }
                leftIdx = i;
            } else if (c == 'R') {
                rightIdx = i;
            }
            // 当前节点为'.', 并且right指针最近，则把当前点重置为R
            else if (rightIdx > leftIdx) {
                sb.setCharAt(i, 'R');
            }
        }
        return sb.toString();
    }

    public void setChar(StringBuilder sb, int from, int to, char c) {
        for (int i = from; i <= to; i++) {
            sb.setCharAt(i, c);
        }
    }
}
