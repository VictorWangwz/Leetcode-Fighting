package quoraoa;

import java.util.HashMap;
import java.util.Map;

//Given a list of integers, count the number of 'good tuples' that can be created. A 'good tuple' is defined as consecutive triplets having exactly 2 duplicate elements.
public class GoodTuple {

    public int findGoodTuples0(int[] nums){
        if(nums == null || nums.length < 3){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 3; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }

        int rst = 0;
        if(map.size() == 2){
            rst++;
        }

        for(int i = 3; i < nums.length; i++){
            if(map.get(nums[i - 3]) == 1){
                map.remove(nums[i - 3]);
            }else{
                map.put(nums[i - 3], map.get(nums[i - 3]) - 1);
            }
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
            if(map.size() == 2){
                rst++;
            }
        }
        return rst;
    }

    public int findGoodTuples(int[] nums){
        int rst = 0;
        for(int i = 1; i < nums.length - 1; i++){
            if((nums[i] == nums[i - 1] && nums[i] != nums[i + 1])
                    ||(nums[i] == nums[i + 1] && nums[i] != nums[i - 1])
            || (nums[i - 1] == nums[i + 1] && nums[i - 1] != nums[i])){
                rst++;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,4,4,4,4,4};
        GoodTuple goodTuple = new GoodTuple();
        int rst = goodTuple.findGoodTuples(nums);
        System.out.println(rst);
    }
}
