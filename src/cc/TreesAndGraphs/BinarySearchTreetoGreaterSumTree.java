package cc.TreesAndGraphs;
//1038. Binary Search Tree to Greater Sum Tree
public class BinarySearchTreetoGreaterSumTree {

    public int helper(TreeNode root, int sum){
        if(root == null) return sum;
        root.val += helper(root.right, sum);
        return  helper(root.left, root.val);

    }

    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;



    }
}
