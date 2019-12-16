package quoraoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFreqNum {

    public int[] findMostFreqNum(int[] nums){

        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int freq = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            int tmp =  num;
            while(tmp != 0){
                if(!map.containsKey(tmp % 10)){
                    map.put(tmp % 10, 1);
                }
                else{
                    map.put(tmp % 10, map.get(tmp % 10) + 1);
                }
                tmp = tmp /10;
            }
            freq = map.get(num % 10) > freq?map.get(num % 10) : freq;
        }
        List<Integer> list = new ArrayList<>();
        for(Integer i: map.keySet()){
            if(map.get(i) == freq){
                list.add(i);
            }
        }
        int[] rst = list.stream().mapToInt(i-> i).toArray();
        return rst;

    }

    public static void main(String[] args) {
        int[] A = {22,3,33,2,5};
        MostFreqNum mostFreqNum = new MostFreqNum();
        int[] rst = mostFreqNum.findMostFreqNum(A);
        System.out.println(rst);
    }
}
