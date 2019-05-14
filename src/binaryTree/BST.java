package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BST {

    TreeNode root;

    public BST(int[] preorder, int[] inorder){
        BuildTree b = new BuildTree();
        root = b.buildTree(preorder, inorder);
        assert isValidBSTNotGetInorder(root);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !s.empty()){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            rst.add(temp.val);
            temp = temp.right;
        }
        return rst;
    }

    //Validate BST by getting inorder first
    public boolean isValidBST(TreeNode root) {
        List<Integer> in_order = inorderTraversal(root);
        if(in_order.isEmpty()) return true;
        int pre_val = in_order.get(0);
        for(int i = 1; i < in_order.size(); i++){
            int cur_val = in_order.get(i);
            if(pre_val >= cur_val) return false;
            pre_val = cur_val;
        }
        return true;
    }

    //Validate BST by modifying inorder traversal
    public boolean isValidBSTNotGetInorder(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !s.empty()){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            if(!rst.isEmpty()) {
                if(((LinkedList<Integer>) rst).getLast() >= temp.val)
                    return false;
            }
            rst.add(temp.val);
            temp = temp.right;
        }
        return true;
    }

    // Flatten a BST to a tree with only left subtree in ascending order
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode cur = root;
        root.left = null;
        root.right = left;
        while(cur.right != null) cur = cur.right;
        cur.right = right;
        return;
    }

    //Get the successor of node in inorder traversal
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !s.empty()){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            if(temp.val > p.val) return temp;
            temp = temp.right;
        }
        return null;
    }

    // Search Range in a BST
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> rst = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !s.empty()){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            if(temp.val >= k1 && temp.val <= k2) rst.add(temp.val);
            temp = temp.right;
        }
        return rst;
    }

    // Search value in a BST
    public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !s.empty()){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            if(temp.val == val) return temp;
            temp = temp.right;
        }
        return null;
    }

    // Insert value into BST
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
        }
        if(root.val < val){
            if(root.right == null) {
                root.right = new TreeNode(val);
                return root;
            }
            else{
                root.right = insertIntoBST(root.right, val);
            }
        }
        else if(root.val > val){
            if(root.left == null){
                root.left = new TreeNode(val);
            }
            else{
                root.left = insertIntoBST(root.left, val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 4, 2, 1, 3, 7},
                inorder = { 1, 2, 3, 4, 7 };

        BST bst = new BST(preorder, inorder);
        TreeNode new_root = bst.insertIntoBST(bst.root, 5);
        new_root = bst.insertIntoBST(new_root, 7);
        System.out.println(new_root);
    }
}
