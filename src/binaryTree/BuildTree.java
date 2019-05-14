package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    //Build a tree with preorder and inorder
    int pre_idx = 0;
    int[] preorder, inorder;
    Map<Integer, Integer> m = new HashMap<>();
    public TreeNode buildTreeHelper(int inLeft, int inRight){
        if(inLeft == inRight){
            return null;
        }
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        int in_idx = m.get(preorder[pre_idx]);
        pre_idx ++;
        root.left = buildTreeHelper(inLeft, in_idx);
        root.right = buildTreeHelper(in_idx+1, inRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int idx = 0;
        for(Integer val: inorder){
            m.put(val, idx++);
        }
        return buildTreeHelper(0, inorder.length);
    }

    public static void main(String[] args) {
        int[] preorder = { 3,9,20,15,7 },
                inorder = { 9,3,15,20,7 };
        Traversal t = new Traversal();
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(preorder, inorder);
        System.out.println(t.preorderTraversal(root));

    }
}
