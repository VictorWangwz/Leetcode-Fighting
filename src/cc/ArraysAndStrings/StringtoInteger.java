package cc.ArraysAndStrings;
//8. String to Integer (atoi)
public class StringtoInteger {
    public int myAtoi(String str) {
        boolean set = false;
        int sign = 1;
        int rst = 0;
        for(int i  = 0; i < str.length(); i ++){
            char c = str.charAt(i);
            if(!set && c == ' '){
                continue;
            }
            if(c == '-'){
                if(!set){
                    sign = -1;
                    set = true;
                    continue;
                }
                else{
                    break;
                }

            }
            if(c == '+'){
                if(!set){
                    sign = 1;
                    set = true;
                    continue;
                }
                else{
                    break;
                }

            }
            if(c > '9' || c < '0'){
                break;
            }
            set = true;
            if(sign == -1){
                long tmp = rst;
                tmp *= 10;
                tmp -= Integer.valueOf(String.valueOf(c));
                if(tmp <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                rst = (int)tmp;
            }
            else{
                long tmp = rst;
                tmp *= 10;
                tmp += Integer.valueOf(String.valueOf(c));
                if(tmp >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                rst = (int)tmp;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        String str = "2147483648";
        StringtoInteger stringtoInteger = new StringtoInteger();
        int rst = stringtoInteger.myAtoi(str);
        System.out.println(rst);
    }
}
