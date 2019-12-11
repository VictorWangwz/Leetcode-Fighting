package cc.TreesAndGraphs;

import java.util.Arrays;

//889. Construct Binary Tree from Preorder and Postorder Traversal
public class ConstructBinaryTreefromPreorderandPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        if(n == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if(n == 1){
            return root;
        }

        int leftIdx = 0;
        for(int i = 0; i < n; i++){
            if(post[i] == pre[1]){
                leftIdx = i + 1;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, leftIdx + 1), Arrays.copyOfRange(post, 0, leftIdx));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, leftIdx + 1, n ), Arrays.copyOfRange(post, leftIdx, n - 1));
        return root;
    }
}
