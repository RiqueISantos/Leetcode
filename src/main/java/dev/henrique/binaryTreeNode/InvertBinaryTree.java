package dev.henrique.binaryTreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode leftChild = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode rightChild = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        TreeNode root = new TreeNode(4, leftChild, rightChild);

        printTree(root);
        System.out.println();
        TreeNode invertedTree = invertTree(root);
        printTree(invertedTree);

    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;

        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

}
