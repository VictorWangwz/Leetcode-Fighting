package vopreparation0530;

import binaryTree.BuildTree;
import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//103. Binary Tree Zigzag Level Order Traversal
public class ZigzagTreeTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        return rst;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7},
                inorder = { 9, 3, 15, 20, 7 };
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(preorder, inorder);
        int[][] expected = {
                {3},
                {20,9},
                {15,7}
        };
        List<List<Integer>> rst = zigzagLevelOrder(root);
        System.out.println(rst);
    }
}
