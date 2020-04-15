package leetCodes;

import java.util.LinkedList;
import java.util.List;


/**
 * 找到二叉树中访问元素和等于目标的路径，DFS前序遍历+回溯（递归）
 */
public class Interview34 {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    private void recur(TreeNode root, int tar) {
       if (root == null) return;
       path.add(root.val);
       tar -= root.val;
       if (tar == 0 && root.left == null && root.right == null)
           res.add(new LinkedList<>(path));
       recur(root.left, tar);
       recur(root.right, tar);
       path.removeLast();
    }

    public static void main(String[] args) {
        Interview34 test = new Interview34();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(0);
        System.out.print(test.pathSum(treeNode, 4));
    }
}

