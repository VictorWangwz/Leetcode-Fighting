package oa2preparation0519;


import oa2preparation0519.helper.BuildTree;
import oa2preparation0519.helper.TreeNode;

public class SubtreeMaxAverNode {
    private static class ResultType {
        TreeNode node;
        int sum;
        int size;
        public ResultType(TreeNode node, int sum, int size) {
            this.node = node;
            this.sum = sum;
            this.size = size;
        }
    }

    static ResultType rst;
    public static ResultType helper(TreeNode root){
        if(root == null) return new ResultType(root, 0, 0);
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType cur = new ResultType(root, left.sum + right.sum + root.val, left.size + right.size + 1);
        if(rst == null || rst.sum * cur.size < cur.sum * rst.size ){
            rst = cur;
        }
        return cur;
    }
    public static TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return rst.node;
    }

    public static void main(String[] args) {
        int[] preorder = { 2, 1, 3},
                inorder = { 1, 2, 3 };
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(preorder, inorder);
        TreeNode rst = findSubtree2(root);
        System.out.println(rst);
    }
}
