package cc.TreesAndGraphs;
//298. Binary Tree Longest Consecutive Sequence
public class BinaryTreeLongestConsecutiveSequence {
    private int rst = 0;
    private void helper(TreeNode root, TreeNode p, int max){
        if(root == null){
            return;
        }
        if(p != null && root.val == p.val + 1){
            max ++;
        }else{
            max = 1;
        }
        if(max > rst){
            rst = max;
        }
        helper(root.left, root, max);
        helper(root.right, root, max);

    }
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, null, 0);
        return rst;
    }
}
