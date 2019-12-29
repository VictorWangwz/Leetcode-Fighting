package cc.TreesAndGraphs;
//543. Diameter of Binary Tree
public class DiameterofBinaryTree {
    int rst = 0;

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int depthL = dfs(root.left);
        int depthR = dfs(root.right);
        if(depthL + depthR > rst){
            rst = depthL + depthR;
        }
        return Math.max(depthL, depthR) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return rst;
    }
}
