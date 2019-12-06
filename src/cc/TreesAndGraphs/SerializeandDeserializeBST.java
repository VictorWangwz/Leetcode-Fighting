package cc.TreesAndGraphs;

public class SerializeandDeserializeBST {


    private StringBuffer preorderTraversal(TreeNode root, StringBuffer preorder){
        if(root == null ) return preorder;
        preorder.append(root.val);
        preorderTraversal(root.left, preorder);
        preorderTraversal(root.right, preorder);
        return preorder;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer rst =  preorderTraversal(root, new StringBuffer());
        return rst.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

}
