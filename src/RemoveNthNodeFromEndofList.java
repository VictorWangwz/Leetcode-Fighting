//19. Remove Nth Node From End of List
public class RemoveNthNodeFromEndofList {

  public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode front = dummy;
        int num = n + 1;

        while(num > 0){
            front = front.next;
            num--;
        }


        while(front != null) {
            front = front.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node = new ListNode(1);
        head.next = node;
        int n = 1;
        removeNthFromEnd(head, n);
    }
}
