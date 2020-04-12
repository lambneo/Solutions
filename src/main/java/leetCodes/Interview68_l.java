package leetCodes;

/**
 * 二叉搜索树的最近邻公共祖先
 * 说明有以下几种情况：
 * 二叉树本身为空，root == null ，return root
 * p.val == q.val ,一个节点也可以是它自己的祖先
 * p.val 和 q.val 都小于 root.val
 * (两个子节点的值都小于根节点的值，说明它们的公共节点只能在二叉树的左子树寻找）
 * p.val 和 q.val 都大于 root.val
 * (两个子节点的值都大于根节点的值，说明它们的公共节点只能在二叉树的右子树寻找）
 * 如果上述的情况皆不满足，说明其公共节点既不在左子树也不在右子树上，只能为最顶端的公共节点，return root
 * p.val < root.val && q.val > root.val 或 p.val > root.val && q.val < root.val
 *
 */
public class Interview68_l {
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    //非递归
    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p, TreeNode q){
        while (root != null){
            if (p.val > root.val && q.val > root.val)
                root= root.right;
            else if (p.val < root.val && q.val < root.val)
                root = root.left;
            else break;
        }
        return root;
    }

}
