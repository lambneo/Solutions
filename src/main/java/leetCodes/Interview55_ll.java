package leetCodes;


/**
 * 判断二叉树是否为平衡二叉树，使用递归
 */
public class Interview55_ll {


    //使用-1来表示，避免额外使用boolean
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        //左子树判别
        int left = recur(root.left);
        if(left == -1) return -1;

        //右子树判别
        int right = recur(root.right);
        if(right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    //暴力
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

}
