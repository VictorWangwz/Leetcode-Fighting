package quorapi;
//81. Search in Rotated Sorted Array II
public class SearchinRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
      return biSearch(nums, 0, nums.length - 1, target);
    }

    private boolean biSearch(int[] nums, int l, int r, int target){
        if (l > r){
            return false;
        }
        int mid = (l + r) / 2;
        if(nums[mid] == target){
            return true;
        }

        return biSearch(nums, l, mid - 1, target) || biSearch(nums, mid + 1, r, target);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,3,1};
        int target = 3;
        SearchinRotatedSortedArrayII searchinRotatedSortedArrayII = new SearchinRotatedSortedArrayII();
        boolean rst = searchinRotatedSortedArrayII.search(nums, target);
        System.out.println(rst);

    }
}
