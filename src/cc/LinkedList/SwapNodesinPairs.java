package cc.LinkedList;
//24. Swap Nodes in Pairs
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode n1 = head, n2 = head.next;
        while(n1 != null && n2 != null){
            ListNode tmp = n2.next;
            prev.next = n2;
            n2.next = n1;
            n1.next = tmp;
            prev = n1;
            n1 = tmp;
            if(tmp == null || tmp.next == null){
                break;
            }
            n2 = tmp.next;
        }
        return dummy.next;
    }
}
