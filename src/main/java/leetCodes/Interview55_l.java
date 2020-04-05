package leetCodes;

import java.util.LinkedList;
import java.util.List;

/**
 * 求二叉树的最大深度：BFS与DFS
 */
public class Interview55_l {
    public int maxDepthDFS(TreeNode root) {
        //最下方点为空，初始值为0
            if(root == null) return 0;
            return Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right)) + 1;
    }

    //采用队列，队列保存每次遍历的节点的左右孩子值，按层遍历，知道为全空层
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        List<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}}, tmp;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode treeNode : queue){
                if (treeNode.left != null) tmp.add(treeNode.left);
                if (treeNode.right != null) tmp.add(treeNode.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        Interview55_l solo = new Interview55_l();
        int res = solo.maxDepthBFS(treeNode);
        System.out.print(res);
    }
}
