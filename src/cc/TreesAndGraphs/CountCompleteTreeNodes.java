package cc.TreesAndGraphs;
//222. Count Complete Tree Nodes
public class CountCompleteTreeNodes {
    private int rst = 0;
    private void helper(TreeNode root){
        if(root != null){
            rst++;
            if(root.left != null) helper(root.left);
            if(root.right != null) helper(root.right);
        }

    }
    public int countNodes(TreeNode root) {
        helper(root);
        return rst;
    }
}
