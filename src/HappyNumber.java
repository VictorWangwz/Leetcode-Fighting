//202. Happy Number

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {


    private int transfer(int n){
        int newN = 0;
        while ( n!=0){
            newN += (n % 10) * (n % 10);
            n = n / 10;
        }
        return newN;
    }
    public boolean isHappy(int n) {
        Set<Integer> mem = new HashSet<>();
        while( n != 1){
            n = transfer(n);
            if(mem.contains(n)){
                return false;
            }
            mem.add(n);
        }
        return true;
    }
}
