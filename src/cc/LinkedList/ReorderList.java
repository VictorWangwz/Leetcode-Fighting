package cc.LinkedList;
//143. Reorder List
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return ;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secHalf = slow.next;
        slow.next = null;
        ListNode cur = secHalf, next = secHalf.next;
        cur.next = null;
        while(cur != null && next !=  null){
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }

        secHalf = cur;

        ListNode firstHalf = head;
        while(firstHalf != null && secHalf != null){
            ListNode next1 = firstHalf.next, next2 = secHalf.next;
            firstHalf.next = secHalf;
            secHalf.next = next1;
            firstHalf = next1;
            secHalf = next2;
        }
        return ;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int[] arr = {2,3,4,5};
        ListNode cur = head;
        for(int i: arr){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(head);
    }
}
