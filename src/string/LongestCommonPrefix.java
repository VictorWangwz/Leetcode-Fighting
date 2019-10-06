package string;
//14. Longest Common Prefix
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int size = Integer.MAX_VALUE;
        String shortest = strs[0];
        for(String str: strs){
            if(str.length() < size){
                size = str.length();
                shortest = str;
            }
        }
        for(int i = size; i > 0; i++){
            boolean flag = true;
            String prefix = shortest.substring(0, i);
            for(String s: strs){
                flag = flag && s.indexOf(prefix) == 0;
            }
            if(flag){
                return prefix;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] strs = {"a"};
        String rst = longestCommonPrefix(strs);
        System.out.println(rst);
    }
}
