package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//412. Fizz Buzz
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> rst = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String val;
            if(i%3 == 0 && i%5 == 0){
                val = "FizzBuzz";
            }
            else if(i%3 == 0){
                val = "Fizz";
            }
            else if(i%5 == 0){
                val = "Buzz";
            }
            else{
                val = String.valueOf(i);
            }
            rst.add(val);
        }
        return rst;
    }
}
