package swd2offer;

import javax.jnlp.ClipboardService;
import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.*;

public class TreeErgodic {
    public void PreOrder(TreeNode treeNode){
        if (treeNode == null) return;
        System.out.print(treeNode.val);
        PreOrder(treeNode.left);
        PreOrder(treeNode.right);
    }

    public List<Integer> PreOrderNonrecur(TreeNode treeNode){
        List<Integer> preorderResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = treeNode;
        while (currentNode != null || !stack.isEmpty()) {
            //对于前序遍历，需要一直往二叉树的左子树上走，直道左子树走完。在走左子树的过程中需要输出遇到节点的值
            while (currentNode != null) {
                preorderResult.add(currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            //左边的节点都走完了，需要改变节点方向
            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
        return preorderResult;
    }

    public void MidOrder(TreeNode treeNode){
        if (treeNode == null) return;
        MidOrder(treeNode.left);
        System.out.print(treeNode.val);
        MidOrder(treeNode.right);
    }

    public List<Integer> MidOrderNonrecur(TreeNode treeNode){
        List<Integer> MidorderResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = treeNode;
        while (currentNode != null || !stack.isEmpty()) {
            //对于中序遍历，先不打印
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            //左边的节点都走完了，需要改变节点方向
            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                MidorderResult.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        return MidorderResult;
    }

    public void AfterOrder(TreeNode treeNode){
        if (treeNode == null) return;
        AfterOrder(treeNode.left);
        AfterOrder(treeNode.right);
        System.out.print(treeNode.val);
    }

    //后序遍历的
    public List<Integer> AfterOrderNonrecur(TreeNode treeNode){
        List<Integer> AfterOrderResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = treeNode;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null){
                AfterOrderResult.add(currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.right;
            }

            if (!stack.isEmpty()){
                currentNode = stack.pop();
                currentNode = currentNode.left;
            }
        }

        Collections.reverse(AfterOrderResult);
        return AfterOrderResult;
    }

    public List<Integer> BFS(TreeNode treeNode){
        List<Integer> BFS = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (treeNode == null) return BFS;
        deque.addLast(treeNode);
        TreeNode cur = treeNode;
        while (!deque.isEmpty()){
            cur = deque.pollFirst();
            if (cur.left != null)
                deque.addLast(cur.left);
            if (cur.right != null)
                deque.addLast(cur.right);
            BFS.add(cur.val);
        }
        return BFS;
    }
}
