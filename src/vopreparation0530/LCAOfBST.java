package vopreparation0530;

import binaryTree.BuildTree;
import binaryTree.TreeNode;

//235. Lowest Common Ancestor of a Binary Search Tree
public class LCAOfBST {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return root;
    }
    public static void main(String[] args) {
        int[] preorder = { 6, 2, 0, 4, 3, 5, 8,  7, 9 },
                inorder = { 0, 2, 3, 4, 5, 6, 7, 8, 9};

        BuildTree b = new BuildTree();
        //p = 2, q = 8
        TreeNode expected; // 6
        TreeNode root = b.buildTree(preorder, inorder);
        TreeNode rst = lowestCommonAncestor(root, root, root);
    }
}
