package cc.TreesAndGraphs;
//129. Sum Root to Leaf Numbers
public class SumRoottoLeafNumbers {
    int sum = 0;
    public void helper( TreeNode root, int val){
        if(root == null){
            return ;
        }
        val *= 10 ;
        val += root.val;
        if(root.left == null && root.right == null){

            sum += val;
            return;
        }
        if(root.left != null){
            helper(root.left, val);
        }
        if(root.right != null){
            helper(root.right, val);
        }

    }

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
}
