package cc.TreesAndGraphs;
//101. Symmetric Tree
public class SymmetricTree {

    public boolean helper(TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null){
            return true;
        }
        if((n1 == null && n2 != null) || (n1 != null && n2 == null) || (n1.val != n2.val))
            return false;

        return helper(n1.left, n2.right) && helper(n1.right, n2.left);

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        return helper(root.right, root.left);
    }
}
