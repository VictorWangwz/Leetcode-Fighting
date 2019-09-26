package cc.LinkedList;


//141. Linked List Cycle
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head.next, slow = head;

        while(fast != null && fast.next != null && slow != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
