package cc.ArraysAndStrings;
//28. Implement strStr()
public class ImplementStrStr
{
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
}
