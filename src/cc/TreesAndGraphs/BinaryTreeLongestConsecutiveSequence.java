package cc.TreesAndGraphs;
//298. Binary Tree Longest Consecutive Sequence
public class BinaryTreeLongestConsecutiveSequence {

    private static int rst = 0;
    private void helper(TreeNode root, int max){
        if(root == null){
            return;
        }
        TreeNode node = root;
        if(node.right != null && node.right.val == node.val + 1){
            max ++;
        }
        if(max > rst){
            rst = max;
        }
        helper(root.left, 1);
        helper(root.right, rst);

    }
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, 1);
        return rst;
    }
}
