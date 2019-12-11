package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//43. Multiply Strings
public class MultiplyStrings {

    private String muti(String s, String num, int idx){
        StringBuffer rst = new StringBuffer();
        while(idx > 0){
            rst.append("0");
            idx--;
        }
        int n = Integer.valueOf(s), carry = 0;
        for(int i = num.length() - 1; i >= 0; i--){
            int n1 = num.charAt(i) - '0';
            int product = (n1 * n  + carry) % 10;
            carry = (n1 * n  + carry) / 10;
            rst.insert(0, String.valueOf(product));
        }
        if(carry != 0){
            rst.insert(0, String.valueOf(carry));
        }
        return rst.toString();
    }

    private String add(String s1, String s2){
        StringBuffer rst = new StringBuffer();
        int i = s1.length() - 1, j = s2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i>=0? s1.charAt(i)-'0':0;
            int n2 = j>=0? s2.charAt(j)-'0':0;
            int sum = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            rst.insert(0, String.valueOf(sum));
            i--;
            j--;
        }
        if(carry != 0){
            rst.insert(0, String.valueOf(carry));
        }
        return rst.toString();
    }


    public String multiply(String num1, String num2) {
        if(num1.length() > num2.length()){
            return multiply(num2, num1);
        }
        if((num1.length() == 1 && Integer.valueOf(num1) == 0) ||(num2.length() == 1&& Integer.valueOf(num2) == 0)){
            return "0";
        }
        List<String> singleRst = new ArrayList<>();
        int n = num1.length();
        for(int i = n-1, k = 0; i >= 0; i--, k++){
            String tmp = muti(num1.substring(i, i+1), num2, k);
            singleRst.add(tmp);
        }
        String rst = "";
        for(String s: singleRst){
            rst = add(s, rst);
        }
        return rst;

    }

    public static void main(String[] args) {
        String num1 = "9133", num2 = "10";
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String rst =  multiplyStrings.multiply(num1, num2);
        System.out.println(rst);
    }
}
