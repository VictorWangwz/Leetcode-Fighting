import java.util.TreeSet;

//220. Contains Duplicate III
public class ContainsDuplicateIII {
    //brute force
    public boolean containsNearbyAlmostDuplicate0(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= k && i + j < nums.length; j++){
                if(Math.abs((long)nums[i] -(long) nums[i + j]) <=(long) t ){
                    return true;
                }
            }
        }
        return false;
    }


    //use treeset
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Integer small = treeSet.ceiling(nums[i]);
            if(small != null && small <= t + nums[i]) return true;
            Integer large = treeSet.floor(nums[i]);
            if(large != null &&  nums[i] <= t + large) return true;
            treeSet.add( nums[i]);
            if(treeSet.size() > k){
                treeSet.remove(nums[i - k]);
            }

        }
        return false;
    }
}
