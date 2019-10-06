package cc.ArraysAndStrings;//443String Compression

public class StringCompression {
    private static char[] chars = {'a','a','b','b','c','c','c'};

    public static int compress(char[] chars) {
        int anchor = 0, w = 0;
        for(int i = 0; i < chars.length; i++){
            if(i == chars.length - 1 || chars[i] != chars[i + 1]){
                chars[w] = chars[anchor];
                w++;
                if(i > anchor){
                    for( char c: ("" + (i - anchor + 1)).toCharArray()){
                        chars[w++] = c;
                    }
                }
                anchor = i + 1;
            }
        }
        return w;
    }

    public static void main(String[] args) {

        int rst = compress(chars);
        System.out.println(rst);
    }
}
