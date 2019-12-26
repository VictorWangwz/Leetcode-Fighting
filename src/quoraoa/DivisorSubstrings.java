package quoraoa;

import java.util.HashSet;
import java.util.Set;
//Give a number n and digit number k find all serial substring is able to divisible n.
public class DivisorSubstrings {

    public int divide(int number, int k){
        String s = String.valueOf(number);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < s.length() - k + 1; i++){
            String sbStr = s.substring(i, i + k);
            int num = Integer.valueOf(sbStr);
            if(number % num == 0){
                set.add(num);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int number = 555;
        int k = 1;
        DivisorSubstrings divisorSubstrings = new DivisorSubstrings();
        int rst = divisorSubstrings.divide(number, k);
        System.out.println(rst);
    }
}
