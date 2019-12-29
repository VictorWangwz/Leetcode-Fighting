package cc.ArraysAndStrings;
//680. Valid Palindrome II
public class ValidPalindromeII
{
    private boolean checkValid(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }

        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        int count = 1;
        while( l <= r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else{
                if(checkValid(s, l+1, r) || checkValid(s, l, r - 1 )){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
