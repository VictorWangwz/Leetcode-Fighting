package quorapi;

import java.util.ArrayList;
import java.util.List;

//113. Path Sum II
public class PathSumII {
    private void helper(TreeNode root, List<Integer> nodePath, int sum){

        if(root == null) return ;
        nodePath.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null ) {
            if( sum == 0){
                rst.add(nodePath);
            }
            return ;
        }
        helper(root.left, new ArrayList<>(nodePath), sum);
        helper(root.right, new ArrayList<>(nodePath), sum);



    }
    List<List<Integer>> rst = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        helper(root, new ArrayList<>(), sum);
        return rst;
    }
}
