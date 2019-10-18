package cc.TreesAndGraphs;
//124. Binary Tree Maximum Path Sum
public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    private int helper(TreeNode node){
        if(node == null) return 0;
        int rst = node.val;
        int left = helper(node.left);
        int right = helper(node.right);
        int tmp = Math.max(left, right);
        if(tmp >0){
            rst += tmp;
        }
        int pathSum = node.val;
        if(left >0){
            pathSum += left;
        }
        if(right > 0){
            pathSum += right;
        }
        if(pathSum > max){
            max = pathSum;
        }
        return rst;

    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }
}
