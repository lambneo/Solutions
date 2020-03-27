package leetCodes;

/**
 * n&1
 * n&n-1
 */
public class Interview15 {

    public int hammingWeight(int n) {
        int res = 0;
//        while(n != 0){
//            res += n&1;
//            n >>>= 1;
//
//        }

        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;

    }

}
