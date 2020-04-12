package leetCodes;

/**
 * 二叉树的最邻公共祖先
 */
public class Interview68_ll {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }
}
