package quorapi;
//28. Implement strStr()
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        for(int i = 0; i <= len1 - len2; i++){
            if(haystack.substring(i, i + len2).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
       String  haystack = "hello", needle = "ll";
       ImplementstrStr implementstrStr = new ImplementstrStr();
       int rst = implementstrStr.strStr(haystack, needle);
       System.out.println(rst);
    }
}
