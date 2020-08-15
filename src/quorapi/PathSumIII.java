package quorapi;
//437. Path Sum III
public class PathSumIII {

    int rst = 0;

    private void findPathSum(TreeNode root, int sum, int cur){

        if(root == null){
            return;
        }

        if(sum == cur + root.val){
            rst++;
        }
        findPathSum(root.left, sum, cur + root.val);
        findPathSum(root.right, sum, cur + root.val);
    }

    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        findPathSum(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return rst;
    }
}
