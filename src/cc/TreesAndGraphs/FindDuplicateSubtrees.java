package cc.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//652. Find Duplicate Subtrees
public class FindDuplicateSubtrees {
    List<TreeNode> rst = new ArrayList<>();
    Map<String, Integer> count = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count(root);
        return rst;
    }

    private String count(TreeNode node){
        if(node == null){
            return "#";
        }
        String serialized;
        if(node.left == null && node.right == null) {
            serialized = "#" + String.valueOf(node.val);
        }else{
            serialized = "#" + String.valueOf(node.val) + count(node.left) + count(node.right);

        }
        if(!count.containsKey(serialized)){
            count.put(serialized, 1);
        }
        else{
            count.put(serialized, count.get(serialized) + 1);
            if(count.get(serialized) == 2){
                rst.add(node);
            }

        }

        return serialized;
    }
}
