package leetCodes;


/**
 * 镜像二叉树
 * 递归转换左右节点
 * <p>
 * 循环遍历
 */
public class Interview27 {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        Swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void Swap(TreeNode root) {
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    //超时
    public void Mirror2(TreeNode root) {
        if (root == null)
            return;
        while (root.left != null || root.right != null) {
            Swap(root);
        }
    }
}
