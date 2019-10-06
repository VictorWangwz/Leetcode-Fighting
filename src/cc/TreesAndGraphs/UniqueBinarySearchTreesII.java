package cc.TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

//95. Unique Binary Search Trees II
public class UniqueBinarySearchTreesII {

    public List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }

        else if( start == end ){
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        else {
            for( int i = start; i <= end; i ++){
                List<TreeNode> left = helper(start, i -1);
                List<TreeNode> right = helper(i + 1, end);

                for( TreeNode l: left){
                    for( TreeNode r: right){
                        TreeNode cur = new TreeNode(i);
                        cur.left = l;
                        cur.right = r;
                        list.add(cur);
                    }
                }


            }
            return list;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> rst = new ArrayList<>();
        if( n == 0 ) return rst;

        return helper(1, n);

    }
}
