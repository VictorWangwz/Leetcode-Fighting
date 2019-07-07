package vopreparation0530;

import binaryTree.BuildTree;
import binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//98. Validate Binary Search Tree
public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        List<Integer> q = new LinkedList<>();
        if(root == null) return true;
        inOrderTraversalRecurse(root, q);
        int cur = q.get(0);
        for(int i = 1; i < q.size(); i++){
            if(cur >=  q.get(i)) return false;
            cur = q.get(i);
        }
        return true;
    }

    public static void inOrderTraversalRecurse(TreeNode root, List<Integer> q){
        if(root == null){
            return;
        }
        inOrderTraversalRecurse(root.left, q);
        q.add(root.val);
        inOrderTraversalRecurse(root.right, q);
        return;
    }

    public static boolean isValidBST2(TreeNode root) {
        List<Integer> q = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root == null) return true;
        TreeNode temp = root;
        while(temp != null || !s.isEmpty()){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            if(!q.isEmpty() && ((LinkedList<Integer>) q).getLast() >= temp.val) return false;
            q.add(temp.val);
            temp = temp.right;
        }
        int cur = q.get(0);
        for(int i = 1; i < q.size(); i++){
            if(cur >=  q.get(i)) return false;
            cur = q.get(i);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] preorder = { 2, 1, 3 },
                inorder = { 1, 2, 3};
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(preorder, inorder);
        boolean rst = isValidBST2(root);
        boolean expected = true;
        System.out.println(rst == expected);
    }
}
