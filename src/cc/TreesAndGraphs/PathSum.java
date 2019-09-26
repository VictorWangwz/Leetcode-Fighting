package cc.TreesAndGraphs;
//112. Path Sum
public class PathSum {
    private boolean helper(TreeNode root, int sum, int cSum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return cSum + root.val == sum;
        }
        return helper(root.left, sum, cSum + root.val) ||
                helper(root.right, sum, cSum + root.val);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root  == null ) return false;

        return helper( root, sum, 0);
    }

}
