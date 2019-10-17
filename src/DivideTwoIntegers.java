//29. Divide Two Integers
//todo
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(Math.abs(dividend) < Math.abs(divisor)){
            return 0;
        }
        int sign = -1;
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            sign = 1;
        }

        int rest = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int rst = 0;
        while(rest >= 0){
            rest -= divisor;
            rst++;
        }
        rst --;
        return rst * sign;
    }

    public static void main(String[] args) {

        int dividend = -2147483648;
        int divisor = -1;
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        int rst = divideTwoIntegers.divide(dividend, divisor);
        System.out.println(rst);
    }
}
