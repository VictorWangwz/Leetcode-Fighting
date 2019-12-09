package cc.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

//166. Fraction to Recurring Decimal
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0 && denominator != 0){
            return "0";
        }
        if(numerator == 0 && denominator == 0){
            return "1";
        }
        StringBuffer sb = new StringBuffer();
        //need to set the long
        long divided = Math.abs((long) numerator);
        long divider =  Math.abs((long)denominator);
        if(numerator > 0 ^denominator > 0){
            sb.append("-");
        }
        sb.append(String.valueOf(divided/divider));
        long remain = divided % divider;
        if(remain == 0){
            return sb.toString();
        }
        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while(remain != 0){
            if(map.containsKey(remain)){
                sb.insert(map.get(remain), "(");
                sb.append(")");
                break;

            }
            map.put(remain, sb.length());
            remain *= 10;
            sb.append(remain / divider);
            remain %= divider;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int numerator = -1, denominator = -2147483648;
        FractiontoRecurringDecimal fractiontoRecurringDecimal = new FractiontoRecurringDecimal();
        String rst = fractiontoRecurringDecimal.fractionToDecimal(numerator, denominator);
        System.out.println(rst);
    }
}
