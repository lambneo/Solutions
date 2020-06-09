package swd2offer;


/**
 * 二叉搜索树转为双向链表
 */
public class Interview36 {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        //头尾相连
        head.left = pre;
        pre.right = head;
        return head;
    }

    //中序遍历，若pre为空则为中序的第一个递归，将其设置为head
    //否则将当前节点的左节点指向pre，并将当前节点设为pre
    void dfs(Node cur){
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}

