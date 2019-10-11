package cc.TreesAndGraphs;//545. Boundary of Binary Tree

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryofBinaryTree {

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    private void leftBound(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        while(node != null){
            if(!isLeaf(node)){
                list.add(node.val);
            }
            if(node.left != null){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        return;

    }

    private void bottomBound(TreeNode node, List<Integer> list){
        if(isLeaf(node)){
            list.add(node.val);
        }
        else{
            if(node.left != null){
                bottomBound(node.left, list);
            }
            if(node.right != null){
                bottomBound(node.right, list);
            }
        }
    }

    private void rightBound(TreeNode node, List<Integer> list){
        Stack<Integer> s = new Stack<>();
        if(node == null){
            return;
        }
        while(node != null){
            if(!isLeaf(node)){
                s.push(node.val);
            }
            if(node.right != null){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
        while( !s.isEmpty()){
            list.add(s.pop());
        }
        return;
    }


    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        if(!isLeaf(root)){
            rst.add(root.val);
        }

        leftBound(root.left, rst);
        bottomBound(root, rst);
        rightBound(root.right, rst);
        return rst;
    }
}
