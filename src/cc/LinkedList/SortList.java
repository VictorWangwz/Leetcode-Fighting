package cc.LinkedList;
//148. Sort List
public class SortList {

    //quick sort O(nlogn) time, O(1) space
    private void swap(ListNode p1, ListNode p2){
        if(p1 == null || p2 == null){
            return;
        }
        int tmp = p1.val;
        p1.val = p2.val;
        p2.val = tmp;
    }

    private void quickSort(ListNode l, ListNode r){
        if(l == null || l == r){
            return;
        }
        ListNode p1 = l, p2 = l.next;
        while( p2 != r ){
            if(p2.val < l.val){
                p1 = p1.next;
                swap(p1, p2);
            }
            p2 = p2.next;
        }
        swap(p1, l);
        quickSort(l, p1);
        quickSort(p1.next, r);
    }

    public ListNode sortList0(ListNode head) {
        quickSort(head, null);
        return head;
    }


    //merge sort
    private ListNode getMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode  pl = head, pf = head.next;
        while( pf != null && pf.next != null){
            pf = pf.next.next;
            pl = pl.next;
        }
        ListNode  pr = pl;
        pl = pl.next;
        pr.next = null;
        return pl;

    }


    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);

    }

    private ListNode merge(ListNode l, ListNode r){
        if(l.val > r.val ){
            return merge(r, l);
        }
        ListNode dummy = new ListNode(0), cur = dummy;

        while(l != null  && r != null){
            if(l.val < r.val){
                cur.next = l;
                cur = cur.next;
                ListNode tmp = l;
                l = l.next;
                tmp.next = null;
            }else{
                cur.next = r;
                cur = cur.next;
                ListNode tmp = r;
                r = r.next;
                tmp.next = null;
            }
        }

        if( l != null){
            cur.next = l;
        }
        else if( r != null){
            cur.next = r;
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        ListNode dummy = new ListNode(0), cur = dummy;
        for(int i: arr){
            ListNode tmp = new ListNode(i);
            cur.next = tmp;
            cur = cur.next;
        }
        SortList sortList = new SortList();
        ListNode rst = sortList.sortList(dummy.next);
        System.out.println(rst);
    }
}
