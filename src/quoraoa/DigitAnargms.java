package quoraoa;

import java.util.*;

public class DigitAnargms {

    private boolean checkAnagrams(int num1, int num2){
        char[] numChar1 = String.valueOf(num1).toCharArray();
        char[] numChar2 = String.valueOf(num2).toCharArray();
        Arrays.sort(numChar1);
        Arrays.sort(numChar2);
        if(numChar1.length != numChar2.length){
            return false;
        }
        for(int i = 0; i < numChar1.length; i++){
            if(numChar1[i] != numChar2[i]){
                return false;
            }
        }
        return true;


    }

    public int findAnagrams(int[] nums){
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] checked = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(!checked[i]){
                map.put(nums[i], new ArrayList<>());
                checked[i] = true;
                map.get(nums[i]).add(nums[i]);
                for(int j = i + 1; j < nums.length; j++){
                    if(checkAnagrams(nums[i], nums[j])){
                        checked[j] = true;
                        map.get(nums[i]).add(nums[j]);
                    }
                }
            }
        }
        int rst = 0;
        for(Integer i: map.keySet()){
            if(rst < map.get(i).size()){
                rst = map.get(i).size();
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {123,321,132,224,422};
        DigitAnargms digitAnargms = new DigitAnargms();
        int rst = digitAnargms.findAnagrams(nums);
        System.out.println(rst);
    }
}
