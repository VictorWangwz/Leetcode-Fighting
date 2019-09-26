package cc.LinkedList;

import java.util.Stack;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while(p != null){
            stack.push(p.val);
            p = p.next;
        }

        p = head;

        while(p != null){
            int val = stack.pop();
            if(val != p.val){
                return false;
            }
            p = p.next;
        }
        return true;

    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = new ListNode(1);
        head.next = temp;
        temp.next = null;
        boolean rst = isPalindrome(head);
    }
}
