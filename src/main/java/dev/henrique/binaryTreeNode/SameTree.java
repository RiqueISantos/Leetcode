package dev.henrique.binaryTreeNode;

public class SameTree {
    public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(3);
        TreeNode root = new TreeNode(1, leftChild, rightChild);

        TreeNode leftChild2 = new TreeNode(2);
        TreeNode rightChild2 = new TreeNode(4);
        TreeNode root2 = new TreeNode(1, leftChild2, rightChild2);

        boolean result = isSameTree(root, root2);
        System.out.println(result);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
