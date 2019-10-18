//9. Palindrome Number

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        while(x != 0){
            s.push(x % 10);
            q.offer(x % 10);
            x /= 10;
        }
        while(!s.isEmpty()){
            if(s.pop() != q.poll()){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if(x < 0){
            return false;
        }
        String xs = String.valueOf(x);
        int l = 0, r = xs.length() - 1;
        while(l < r){
            if(xs.charAt(l) != xs.charAt(r)){
                return false;
            }
            l++;
            r--;

        }
        return true;
    }
}
