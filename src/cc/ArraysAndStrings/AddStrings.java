package cc.ArraysAndStrings;
//415. Add Strings
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        while(p1 >= 0 || p2 >= 0){
            int n1 = p1 >= 0? num1.charAt(p1--) - '0': 0;
            int n2 = p2 >= 0? num2.charAt(p2--) - '0': 0;
            int sum = n1 + n2 + carry;
            carry = sum /10;
            sb.insert(0, sum % 10);
        }

        if(carry != 0){
            sb.insert(0, carry);
        }
        return sb.toString();

    }
}
