package cc.LinkedList;

import java.util.HashMap;
import java.util.Map;

//138. Copy List with Random Pointer
public class CopyListwithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node preD = new Node(0, head, null), pre = preD;
        Node dummy = new Node(0, null, null), newH = dummy;
        while(pre.next != null){
            pre = pre.next;
            if(!map.containsKey(pre)){
                Node tmp = new Node(pre.val, null, null);
                map.put(pre, tmp);
            }
            if(pre.random != null && !map.containsKey(pre.random)){
                Node tmp = new Node(pre.random.val, null, null);
                map.put(pre.random, tmp);
            }
        }

        pre = preD;
        while(pre.next != null){
            pre = pre.next;
            newH.next = map.get(pre);
            newH = newH.next;
            if(pre.random != null){
                newH.random = map.get(pre.random);
            }
        }
        return dummy.next;

    }
}
