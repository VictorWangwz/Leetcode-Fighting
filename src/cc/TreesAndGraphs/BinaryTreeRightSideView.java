package cc.TreesAndGraphs;

import java.util.*;
//199. Binary Tree Right Side View
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        while(! nodeStack.isEmpty()){
            TreeNode cur = nodeStack.pop();
            int depth = depthStack.pop();
            if(cur != null){
                if(!map.containsKey(depth)){
                    map.put(depth, cur.val);
                }
                nodeStack.push(cur.left);
                nodeStack.push(cur.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }

        }
        for(Integer val: map.values()){
            rst.add(val);
        }
        return rst;

    }
}
