package cc.TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;

//116. Populating Next Right Pointers in Each Node
public class PopulatingNextRightPointersinEachNode {

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        root.next = null;
        if(root.left == null && root.right == null){
            return root;
        }
        List<Node> q1 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            List<Node> q2 = q1;
            q1 = new LinkedList<>();
            while(!q2.isEmpty()){
                Node temp = q2.get(0);
                q2.remove(temp);
                if(temp.right != null){
                    q1.add(temp.right);
                    q1.add(temp.left);
                }
            }
            for( int i = 1; i < q1.size(); i++){
                q1.get(i).next = q1.get(i - 1);
            }
        }
        return root;


    }
}
