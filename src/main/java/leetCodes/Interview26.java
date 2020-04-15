package leetCodes;

/**
 * recur函数判断A,b节点是否相同，isSubStructure递归判断A树的子节点和B的recur
 */
public class Interview26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //分两部分
        return (A != null && B != null) && (isSubStructure(A.left, B) || isSubStructure(A.right, B) || recur(A, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
