public class SortRotArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length - 1;
        int shift = l, len = nums.length;
        if(nums[l]>nums[r]){
            while(l<=r){
                int mid = (l+r)/2;
                if(mid == l){
                    break;
                }
                if(nums[mid]> nums[r]){
                    l = mid;
                }else if(nums[mid] < nums[r]){
                    r = mid;
                }
                else break;
            }
            l = r;
            r = (l-1+len)%len;
            shift = l;
        }
        while((l - shift + len)%len<=(r - shift+ len)%len){
            int mid = (((r - shift + len)%len
                    + (l - shift + len)%len) /2 + shift + len)%len;
            if(mid == l ){
                if(nums[mid] != target && nums[r]!= target)
                    return -1;
                else if(nums[mid] == target)
                    return mid;
                else
                    return r;
            }
            if(target == nums[mid])
                return mid;
            else if(target> nums[mid]){
                l = (mid + 1)%len;
            }
            else r = (len+mid-1)%len;
        }
        return -1;
    }

    public static void main(String[] args) {
        SortRotArray s = new SortRotArray();
        int[] nums = {1,3,5};
        int target = 0;
        System.out.println(s.search(nums, target));
    }
}
