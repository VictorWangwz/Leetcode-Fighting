import java.util.Comparator;
import java.util.PriorityQueue;

//23
public class MergeSortedList {

    private static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) return 1;
                else if(o1 < o2) return -1;
                else return 0;
            }
        });
        for(ListNode l: lists){
            while(l != null){
                pq.add(l.val);
                l = l.next;
            }
        }
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while(pq.size() != 0){
            int val = pq.remove();
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] l = {
                {1, 4, 5},
                {1, 3, 4},
                {2, 6}
        };
        ListNode[] input = new ListNode[l.length];
        int idx = 0;
        for(int[] li: l){
            ListNode n1 = new ListNode(0);
            ListNode head = n1;
            for(int i: li){
                n1.next = new ListNode(i);
                n1 = n1.next;
            }
            input[idx++] = head.next;

        }

        System.out.println(mergeKLists(input));
    }

}
