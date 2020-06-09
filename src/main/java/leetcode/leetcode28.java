package leetcode;


public class leetcode28 {

    //KMP算法实现
    public int strStr(String haystack, String needle) {
        int lenh = haystack.length();
        int lenn = needle.length();
        int[] next = new int[lenn];
        int i = 0, j = 0, ans = 0;
        boolean flag = false;

        //若needle数组长度大于haystack，或两者数组长度相等但首元素不相同，则必定匹配失败
        //需要考虑haystack和needle数组为空的情况，题目所注needle数组为空时输出为0，所以这里用O(1)算法
        if (needle.length() == 0)
            return 0;

        if (haystack.length() < needle.length() ||
                (haystack.length() == needle.length() && haystack.charAt(0) != needle.charAt(0)))
            return -1;

        //一般情况，即needle数组长度小于haystack时
        while (i < lenh && j < lenn) {
            flag = false;
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                flag = true;
            } else {
                i -= Next(needle, next, j);
                j = 0;
                flag = false;
                if (lenh - i < lenn)   //若更新索引后，剩余的haystack数组长度小于needle数组，则终止循环
                    break;
            }

        }
        if (flag)
            ans = i - lenn;
        else {
            ans = -1;
        }
        return ans;

    }


    //寻找不包含失配元素的模式数组的最长前缀后缀长度,即KMP中next[]数组,复杂度过高，为O(n^2),调取相比next函数需加一
    public int len(int OrderOfMismatch, String input) {
        int index = 1, ans = 0;
        if (OrderOfMismatch == 1)
            return -1;
        while (index < OrderOfMismatch - 1) {
            boolean flag = true;
            for (int j = 0; j < index; j++) {
                if (input.charAt(j) != input.charAt(OrderOfMismatch - index + j - 1))
                    flag = false;
            }
            if (flag)
                ans = Math.max(ans, index);

            index++;
        }
        return ans;
    }

    //官方next求法
    public int Next(String str, int[] next, int OrderOfMismatch) {
        int j = 0, k = -1;
        int len = str.length();
        next[0] = -1;
        while (j < len - 1) { //这个地方要注意是len-1  不是len，不然会数组越界的
            if (k == -1) {
                next[++j] = 0;
                k = 0;
            } else if (str.charAt(j) == str.charAt(k)) {  //	确定next(j+1)的值
                k++;
                next[++j] = k;
            } else {
                k = next[k];
            }
        }

        return next[OrderOfMismatch];

//			for(int i=0; i<next.length; i++) {
//				System.out.printf(next[i] + "  ");
//			}
    }


    //此为java的IndexOf库函数,为最佳算法
    public int strStrOffical(String haystack, String needle) {
        return indexOf(haystack.toCharArray(), 0, haystack.length(), needle.toCharArray(), 0, needle.length(), 0);
    }

    private int indexOf(char[] source, int sourceOffset, int sourceCount,
                        char[] target, int targetOffset, int targetCount,
                        int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }

}
