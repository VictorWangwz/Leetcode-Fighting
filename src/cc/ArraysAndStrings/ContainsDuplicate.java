package cc.ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

//217. Contains Duplicate
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                return true;
            }
            else{
                set.add(num);
            }
        }
        return false;
    }
}
