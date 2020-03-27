package leetCodes;

public class Leetcode_4_Solutions {
    /**
     * @leetcode 第四题，为两个不等长度的已排序的数组求出中位数
     * solution:可参照管官方题解，
     */

    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;  //ceil
            int j = halfLen - i; //floor
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                }

                //考虑m=n时数组不会溢出边界
                else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                }

                //考虑m=n时数组不会溢出边界
                else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    public static double FindMedianSortedArrays(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;  //ensure len1 >= len2
        if (a > b) {
            int[] temp = A;
            A = B;
            B = temp;
            int t = a;
            a = b;
            b = t;
        }
        int iMin = 0;
        int iMax = a;
        int halfLen = (a + b + 1) / 2;
        //dividing algorithm
        while (iMin < iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            double LeftMax = 0.0;
            double RightMin = 0.0;
            if (i <= iMax && A[i] < B[j - 1]) {
                iMin = i + 1;  //i too small
            } else if (i >= iMin && B[j] < A[i - 1]) {
                iMax = i - 1; //i too big
            } else {
                if (i == 0) {
                    LeftMax = B[j - 1];
                } else if (j == 0) {
                    LeftMax = A[j - 1];
                } else {
                    LeftMax = Math.max(B[j - 1], A[j - 1]);
                }
                if ((a + b) % 2 == 1) {
                    return LeftMax;
                }

                if (i == a) {
                    RightMin = B[j];
                } else if (j == b) {
                    RightMin = A[i];
                } else {
                    RightMin = Math.min(A[i], B[j]);
                }
                if ((a + b) % 2 == 0) {
                    return (RightMin + LeftMax) / 2.0;
                }
            }
        }


        return 0;
    }

    public static void main(String[] agrs) {
//		int[] t1 = {7,9,10,11,28,31};
//		int[] t2 = {1,2,3};
        int[] t1 = {1, 2};
        int[] t2 = {3, 4};
//		System.out.println(findMedianSortedArrays(t1, t2));
        System.out.println(findMedianSortedArrays2(t1, t2));
    }


}
