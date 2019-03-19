public class LongPalinSubstring {
    public int findSubstring(String s, int i, int j){
        while(i>=0  && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j-i+1-2;
    }
    public String longestPalindrome(String s) {
        if(s==null || s.length() == 0){
            return "";
        }
        int len = 0;
        String res = "";
        int start=0, end=0;
        for(int i=0; i< s.length(); i++){
            int l1 = findSubstring(s, i, i);
            int l2 = findSubstring(s, i, i+1);
            len = l1>l2?l1:l2;
            if (len>end-start){
                start = i -(len-1)/2;
                end = i + len/2;
            }


        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        LongPalinSubstring l = new LongPalinSubstring();
        String s = "babad";
        System.out.print(l.longestPalindrome(s));
    }
}
