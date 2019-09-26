package cc.LinkedList;//876. Middle of the Linked List

public class MiddleoftheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null){
            fast = fast.next;

            if(fast == null){
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
