package googleoa;

import java.util.HashMap;
import java.util.Map;

//1088. Confusing Number II
public class ConfusingNumberII {

    //time limit exceeded
    private static boolean validate(int num){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(0,0);
        map.put(6,9);
        map.put(9,6);
        map.put(8,8);

        int oldNum = num;
        int newNum = 0;
        while(num != 0){
            if(!map.containsKey(num % 10)){
                return false;
            }
            newNum = newNum * 10 + map.get(num % 10);
            num /= 10;
        }
        return newNum != oldNum;
    }


    public static int confusingNumberII(int N) {
        int rst = 0;
        for(int i = 1; i <= N; i++){
            if(validate(i)){
                rst ++;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int N = 20;
        int rst = confusingNumberII(N);
        System.out.println(rst);
    }
}
