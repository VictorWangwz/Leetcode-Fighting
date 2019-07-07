package vopreparation0530;

import binaryTree.BuildTree;
import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLeavesInBST {
    public static List<List<Integer>> findLeaves(TreeNode root) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, 5, 3 },
                inorder = { 4, 2, 5, 1, 3};
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(preorder, inorder);
        List<List<Integer>> rst = findLeaves(root);
        List<List<Integer>> expected = new ArrayList<>();
        Integer[][] expected_rst = {{4, 5, 3}, {2}, {1}};
        for(Integer[] leaves: expected_rst){
            expected.add(Arrays.asList(leaves));
        }
        System.out.print(expected.equals(rst));
    }

}
