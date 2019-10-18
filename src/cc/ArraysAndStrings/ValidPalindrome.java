package cc.ArraysAndStrings;
//125. Valid Palindrome
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            char lc = Character.toLowerCase(s.charAt(l));
            if(!Character.isLetterOrDigit(lc)){
                l ++;
                continue;
            }
            char rc = Character.toLowerCase(s.charAt(r));
            if(!Character.isLetterOrDigit(rc)){
                r--;
                continue;
            }
            if(rc != lc){
                return false;
            }
            r --;
            l ++;
        }
        return true;

    }
}
