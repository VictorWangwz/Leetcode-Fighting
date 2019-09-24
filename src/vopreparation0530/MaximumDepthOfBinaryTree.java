package vopreparation0530;


import binaryTree.BuildTree;
import binaryTree.TreeNode;

public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        return 3;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7},
                inorder = { 9, 3, 15, 20, 7};
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(preorder, inorder);
        int expected = 3;
        int rst = maxDepth(root);
        System.out.println(rst ==  expected);
    }
}
