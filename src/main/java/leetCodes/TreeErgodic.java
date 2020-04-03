package leetCodes;

public class TreeErgodic {
    public void PreOrder(TreeNode treeNode){
        if (treeNode == null) return;
        System.out.print(treeNode.val);
        PreOrder(treeNode.left);
        PreOrder(treeNode.right);
    }

    public void MidOrder(TreeNode treeNode){
        if (treeNode == null) return;
        MidOrder(treeNode.left);
        System.out.print(treeNode.val);
        MidOrder(treeNode.right);
    }

    public void AfterOrder(TreeNode treeNode){
        if (treeNode == null) return;
        AfterOrder(treeNode.left);
        AfterOrder(treeNode.right);
        System.out.print(treeNode.val);
    }
}
