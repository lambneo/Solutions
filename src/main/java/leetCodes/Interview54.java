package leetCodes;


import java.util.Stack;

/**
 * 求二叉搜索树中第k大的数，中序遍历
 */
public class Interview54 {
    int count;
    int result = -1;
    Stack<Integer> stack = new Stack<>();


    public int kthLargest(TreeNode root, int k){
        MidOrder(root);
        for (int i = 0; i < k; i++)
             result = stack.pop();
        return result;
    }

    private void MidOrder(TreeNode root){
        if (root == null) return;
        MidOrder(root.left);
        stack.push(root.val);
        MidOrder(root.right);

    }


}
