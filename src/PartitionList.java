//86. Partition List

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode before1 = new ListNode(0), after1 = new ListNode(0);
        ListNode before2 = before1, after2 = after1;
        while(head != null){
            if(head.val < x){
                before2.next = head;
                before2 = before2.next;
            }
            else{
                after2.next = head;
                after2 = after2.next;
            }
            head = head.next;
        }

        after2.next = null;
        before2.next = after1.next;
        return before1.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = null;
        partition(head, 0);
    }
}
