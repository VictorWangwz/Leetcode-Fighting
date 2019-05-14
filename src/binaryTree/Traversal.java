package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    List<Integer> rst = new LinkedList<>();

    //Preorder traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root == null){
            return rst;
        }
        s.add(root);
        while(!s.isEmpty()){
            TreeNode top = s.pop();
            rst.add(top.val);
            if(top.right != null){
                s.push(top.right);
            }
            if(top.left != null){
                s.push(top.left);
            }

        }
        return rst;
    }

    //Preorder traversal using recursion
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        if(root == null){
            return rst;
        }

        rst.add(root.val);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
        return rst;
    }

    //Inorder traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp != null || !s.empty()){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            rst.add(temp.val);
            temp = temp.right;
        }
        return rst;
    }

    //Inorder traversal using recursion
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if(root == null){
            return rst;
        }
        inorderTraversalRecursive(root.left);
        rst.add(root.val);
        inorderTraversalRecursive(root.right);
        return rst;
    }

    //Postorder traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        List<TreeNode> s = new LinkedList<>();
        if(root == null){
            return rst;
        }
        s.add(root);
        while(!s.isEmpty()){
            TreeNode t = ((LinkedList<TreeNode>) s).pollLast();
            ((LinkedList<Integer>) rst).addFirst(t.val);
            if(t.left != null){
                s.add(t.left);
            }
            if(t.right != null){
                s.add(t.right);
            }
        }
        return rst;
    }

    //Postorder traversal using recursion
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return rst;
        }
        postorderTraversalRecursive(root.left);
        postorderTraversalRecursive(root.right);
        rst.add(root.val);
        return rst;
    }

    //Get maximum depth of a tree
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 +(Math.max(maxDepth(root.left), maxDepth(root.right)));
    }

    //Get all paths of a binary tree
    public void binaryTreePathsHelper(
            TreeNode root,
            List<String> paths,
            String path
    ){
        if(root != null){
            path += Integer.toString(root.val);
            if(root.left == null && root.right == null){
                paths.add(path);
                return ;
            }else{
                path += "->";
                binaryTreePathsHelper(root.left, paths, path);
                binaryTreePathsHelper(root.right, paths, path);
            }
        }

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if(root == null){
            return paths;
        }
        String s = "";
        binaryTreePathsHelper(root, paths, s);
        return paths;

    }

    //Find subtree with minimum sum
    int min = Integer.MAX_VALUE;
    TreeNode node;
    public int findSubtreeWithMinSumHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        int min_sum = root.val + findSubtreeWithMinSumHelper(root.left) + findSubtreeWithMinSumHelper(root.right);
        if(min_sum < min){
            node = root;
            min = min_sum;
        }
        return min_sum;
    }

    public TreeNode findSubtreeWithMinSum(TreeNode root) {
        findSubtreeWithMinSumHelper(root);
        return node;
    }

    //Check if a tree is balanced
    public int treeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(treeDepth(root.right) - treeDepth(root.left)) >=2){
            return false;
        }
        if(isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }

    //Check if a tree is balanced with a customized ResultType
    public ResultType isBalancedWithResultTypeHelper(TreeNode root){
        if(root == null){
            return new ResultType(true, 0);
        }
        ResultType left_rst = isBalancedWithResultTypeHelper(root.left);
        ResultType right_rst = isBalancedWithResultTypeHelper(root.right);
        if(!left_rst.isBalanced || !right_rst.isBalanced || Math.abs(left_rst.depth - right_rst.depth) >=2
        ){
            return new ResultType(false, 0);
        }
        return new ResultType(true, 1 + Math.max(left_rst.depth, right_rst.depth));

    }

    public boolean isBalancedWithResultType(TreeNode root){
        ResultType rst = isBalancedWithResultTypeHelper(root);
        return rst.isBalanced;
    }

    ResultTypeForMaxAve rstForMaxAve;
    float max_average = Integer.MIN_VALUE;
    public ResultTypeForMaxAve findSubTreeWithMaxAverageHelper(TreeNode root){
        if(root == null){
            return new ResultTypeForMaxAve(root);
        }
        ResultTypeForMaxAve rst_left = findSubTreeWithMaxAverageHelper(root.left);
        ResultTypeForMaxAve rst_right = findSubTreeWithMaxAverageHelper(root.right);
        float sum = (rst_left.sum + rst_right.sum + root.val);
        float num = (rst_left.num + rst_right.num + 1);
        if(max_average * num < sum){
            max_average = sum/num;
            rstForMaxAve.sum = sum;
            rstForMaxAve.num = num;
            rstForMaxAve.node = root;
        }
        ResultTypeForMaxAve rt = new ResultTypeForMaxAve(root);
        rt.sum = sum;
        rt.num = num;
        return rt;
    }

    //Find subtree with largest average
    public TreeNode findSubtreeWithMaxAverage(TreeNode root) {
        rstForMaxAve = new ResultTypeForMaxAve(root);
        ResultTypeForMaxAve rst = findSubTreeWithMaxAverageHelper(root);
        return rstForMaxAve.node;
    }

    //Find lowest common ancestor (LCA) of two nodes
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }

    public static void main(String[] args) {
//        int[] preorder = { 3, 9, 20, 15, 7 },
//                inorder = { 9, 3, 15, 20, 7 };
        int[] preorder = { 2, 1, 3},
                inorder = { 1, 2, 3 };
        Traversal t = new Traversal();
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(preorder, inorder);
        BSTIterator bst_iter = new BSTIterator(root);
//        while(bst_iter.hasNext()){
//            System.out.println(bst_iter.next());
//        }
    }
}
