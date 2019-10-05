package googleoa;

import java.util.HashMap;
import java.util.Map;

//246. Strobogrammatic Number
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0){
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('9','6');
        map.put('6', '9');
        map.put('8','8');
        map.put('0','0');
        map.put('1','1');
        for(int i = 0; i < (num.length() + 1)/2; i++){
            if(!map.containsKey(num.charAt(i))){
                return false;
            }
            if(map.get(num.charAt(i)) != num.charAt(num.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
