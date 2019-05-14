package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class BSTIterator {
    int idx = 0;
    List<Integer> rst = new LinkedList<>();
    public BSTIterator(TreeNode root) {
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

    }

    /** @return the next smallest number */
    public int next() {
        return rst.get(idx++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return rst.size() >= (idx + 1);
    }
}
