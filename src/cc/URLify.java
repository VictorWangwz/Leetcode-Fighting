package cc;
//1.3 URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
//        has sufficient space at the end to hold the additional characters, and that you are given the "true"
//        length of the string. (Note: If implementing in Java, please use a character array so that you can
//        perform this operation in place.)
public class URLify {
    static char[] replaceSpaces(char[] str){
        if(str == null || str.length == 0){
            return str;
        }
        int numOfSpace = 0;
        for(char c: str){
            if( c == ' '){
                numOfSpace ++;
            }
        }
        int idx = str.length  -1;
        while(str[idx] == ' '){
            numOfSpace--;
            idx--;
        }

        char[] rst = new char[idx + 1 + 2* numOfSpace];
        int i = 0;
        for( int j = 0; j <= idx; j++){
            char c = str[j];
            if( c ==  ' '){
                rst[i++] = '%';
                rst[i++] = '2';
                rst[i++] = '0';
            }
            else{
                rst[i++] = c;
            }
        }
        return rst;

    }

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        char[] rst = replaceSpaces(s.toCharArray());
        System.out.println(rst);
    }
}
