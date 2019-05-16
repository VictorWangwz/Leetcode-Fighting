package BFS;

import binaryTree.BuildTree;
import binaryTree.TreeNode;

import java.util.*;

public class BFSInBTree {

    // Binary Tree Level Order Traversal
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new LinkedList<>();
        if(root == null){
            return rst;
        }
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new LinkedList<>();
            List<TreeNode> new_q = new LinkedList<>();
            for(TreeNode temp: q){
                l.add(temp.val);
                if(temp.left != null) new_q.add(temp.left);
                if(temp.right != null) new_q.add(temp.right);
            }
            q = new_q;
            rst.add(l);
        }
        return rst;
    }

    // Binary Tree Level Order Traversal : Bottom up
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new LinkedList<>();
        List<TreeNode> q = new LinkedList<>();
        if(root == null) {
            return rst;
        }
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new LinkedList<>();
            List<TreeNode> new_q = new LinkedList<>();
            for(TreeNode temp: q){
                ((LinkedList<Integer>) l).add(temp.val);
                if(temp.left != null) new_q.add(temp.left);
                if(temp.right != null) new_q.add(temp.right);
            }
            q = new_q;
            ((LinkedList<List<Integer>>) rst).addFirst(l);
        }
        return rst;
    }

    //Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rst = new LinkedList<>();
        if(root == null){
            return rst;
        }
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            List<Integer> l = new LinkedList<>();
            List<TreeNode> new_q = new LinkedList<>();
            for(TreeNode temp: q){
                l.add(temp.val);
                if(flag){
                    if(temp.right != null) ((LinkedList<TreeNode>) new_q).addFirst(temp.right);
                    if(temp.left != null) ((LinkedList<TreeNode>) new_q).addFirst(temp.left);
                }else{
                    if(temp.left != null) ((LinkedList<TreeNode>) new_q).addFirst(temp.left);
                    if(temp.right != null) ((LinkedList<TreeNode>) new_q).addFirst(temp.right);
                }
            }
            flag = !flag;
            q = new_q;
            rst.add(l);
        }
        return rst;
    }

    public static void main(String[] args) {
        BFSInBTree t = new BFSInBTree();
//        int[] preorder = { 1, 2, 4, 3, 5},
//                inorder = { 4, 2, 1, 3, 5 };
        int[] preorder = { 3, 9, 20, 15, 7},
                inorder = { 9, 3, 15, 20, 7 };
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(preorder, inorder);
        System.out.println(t.zigzagLevelOrder(root));
    }
}
