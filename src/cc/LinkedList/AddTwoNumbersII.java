package cc.LinkedList;

//445. Add Two Numbers II
public class AddTwoNumbersII {


    //does not work when number exceeds the limit of long
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        if( l1 == null) return l2;
        if(l2 == null) return l1;

        StringBuffer  s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        ListNode p = l1;
        while(p != null){
            s1.append(p.val);
            p = p.next;
        }
        Long i1 = Long.parseLong(s1.toString());

        p = l2;
        while(p != null){
            s2.append(p.val);
            p = p.next;
        }

        Long i2 = Long.parseLong(s2.toString());

        Long rst = i1 + i2;

        ListNode dummy = new ListNode(0);
        dummy.next = null;

        if(rst == 0){
            ListNode temp = new ListNode(0);
            temp.next = dummy.next;
            dummy.next = temp;
        }
        while(rst != 0){
            Long val = rst % 10;
            ListNode temp = new ListNode( val.intValue() );
            temp.next = dummy.next;
            dummy.next = temp;
            rst /= 10;
        }
        return dummy.next;

    }


    private ListNode reverse(ListNode l){

        ListNode nL = new ListNode(0);
        nL.next = null;

        while(l != null){
            ListNode temp = l;
            l = l.next;
            temp.next = nL.next;
            nL.next = temp;

        }
        return nL.next;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if( l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode l1Reverse = reverse(l1);

        ListNode l2Reverse = reverse(l2);

        ListNode p = new ListNode(0);


        int h = 0;

        while(l1Reverse != null || l2Reverse != null){
            int val1 = l1Reverse == null? 0 : l1Reverse.val;
            int val2 = l2Reverse == null ? 0 : l2Reverse.val;
            int val = (h + val1 + val2) % 10;
            ListNode temp = new ListNode(val);
            h = (0 + val1 + val2) / 10;

            l1Reverse = l1Reverse == null? null : l1Reverse.next;
            l2Reverse = l2Reverse == null? null : l2Reverse.next;


            temp.next = p.next;
            p.next = temp;

        }
        if(h != 0){
            ListNode temp = new ListNode(h);
            temp.next = p.next;
            p.next = temp;
        }
        return p.next;

    }

}
