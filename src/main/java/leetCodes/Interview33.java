package leetCodes;


/**
 * 判断是否为后序遍历，先找出中节点分为左子树右子树，中节点应为最大值
 */
public class Interview33 {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] po, int i, int j) {
        if(i >= j) return true;
        int l = i;
        while(po[l] < po[j]) l++;
        int m = l;
        while(po[l] > po[j]) l++;
        return l == j && recur(po, i, m - 1) && recur(po, m, j - 1);
    }
}
