package cc.LinkedList;
//160. Intersection of Two Linked Lists
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode a = headA, b = headB;
        while(a != null){
            lenA ++;
            a = a.next;
        }
        while(b != null){
            lenB ++;
            b = b.next;
        }
        a = lenA >lenB? headA: headB;
        b = lenA > lenB? headB: headA;

        int diff = Math.abs(lenA - lenB);

        while(diff != 0 && a != null){
            a = a.next;
            diff--;
        }
        while( a != null && b != null){
            if( a == b){
                return a;
            }
            a = a.next;
            b = b.next;
        }

        return null;

    }
}
