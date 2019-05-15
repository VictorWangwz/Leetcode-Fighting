package BFS;

import binaryTree.BuildTree;
import binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Codec {

    public String listToString(List<Integer> l){
        StringBuilder sb = new StringBuilder();
//        sb.append("[");
        // Appends characters one by one
        for (Integer i: l) {
            sb.append(i);
            sb.append(",");
        }
//        sb.replace(sb.length() - 1, sb.length() , "]");

        // convert in string
        String string = sb.toString();
        return string;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> rst = new LinkedList<>();
        if(root == null){
            return "";
        }
        List<TreeNode> q = new LinkedList<>();
        TreeNode invalid_node = null;
        q.add(root);
        int height = 0;
        while(!q.isEmpty()){
            List<TreeNode> new_q = new LinkedList<>();
            int invalid_node_num = 0;
            for(TreeNode temp: q){
                if(temp == null) rst.add(null);
                else rst.add(temp.val);
                if(temp == null || temp.left == null) {
                    new_q.add(invalid_node);
                    invalid_node_num ++;
                }
                else {
                    new_q.add(temp.left);
                }
                if(temp == null || temp.right == null)  {
                    new_q.add(invalid_node);
                    invalid_node_num ++;
                }
                else new_q.add(temp.right);
            }
            q = new_q;
            if(invalid_node_num == Math.pow(2, height + 1)) break;
            height ++;

        }
        return listToString(rst);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<TreeNode> q = new LinkedList<>();
        TreeNode root;
        int height = 1;
        if(data.length() <= 1){
            return null;
        }
        String[] data_arr = data.split(",");

        root = new TreeNode(Integer.parseInt(data_arr[0]));
        q.add(root);
        for(int i = 1; i < data_arr.length; ){
            if(i < Math.pow(2, height)){
                TreeNode cur = ((LinkedList<TreeNode>) q).pollFirst();
                if(cur == null) {
                    i += 2;
                    q.add(null);
                    q.add(null);
                    continue;
                }
                if(data_arr[i].equals("null")) cur.left = null;
                else cur.left = new TreeNode(Integer.parseInt(data_arr[i]));
                q.add(cur.left);
                i += 1;

                if(data_arr[i].equals("null")) cur.right = null;
                else cur.right = new TreeNode(Integer.parseInt(data_arr[i]));
                q.add(cur.right);
                i += 1;

            }

            height ++;
        }
        return root;
    }


//    public String serializeHelp(TreeNode root, String s){
//        if(root == null){
//            s += "null,";
//        }
//        else{
//            s += String.valueOf(root.val) + ",";
//            s = serializeHelp(root.left, s);
//            s = serializeHelp(root.right, s);
//        }
//        return s;
//    }
//
//    public String serialize(TreeNode root) {
//        return serializeHelp(root, "");
//    }
//
//    public TreeNode deserializeHelp(List<String> list){
//        if(list.get(0).equals( "null")){
//            list.remove(0);
//            return null;
//        }
//        TreeNode temp = new TreeNode(Integer.valueOf(list.get(0)));
//        list.remove(0);
//        temp.left = deserializeHelp(list);
//        temp.right = deserializeHelp(list);
//        return temp;
//    }
//
//    public TreeNode deserialize(String data) {
//        String[] data_array = data.split(",");
//        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
//        return deserializeHelp(data_list);
//    }

    public static void main(String[] args) {
        Codec c = new Codec();
        int[] preorder = { 4, 2, 1, 3, 7 },
                inorder = { 1, 2, 3, 4, 7};
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(preorder, inorder);
        String data = c.serialize(root);
        System.out.println(data);
        TreeNode deser_data = c.deserialize(data);
        System.out.println(BFSInBTree.levelOrder(deser_data));
    }
}
