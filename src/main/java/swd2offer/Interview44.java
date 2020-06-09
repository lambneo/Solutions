package swd2offer;

/**
 * 序列化数组位置的值
 */

public class Interview44 {
    public int findNthDigit(int n) {
        if (n<10)
            return n;
        int i = 1;
        while (n>i*(Math.pow(10,i-1))*9){
            n -= i*Math.pow(10,i-1)*9;
            i++;
        }
        String result = String.valueOf((int) Math.pow(10,i-1) + (n-1) / i);
        return result.charAt((n-1)%i)-'0';
    }
}
