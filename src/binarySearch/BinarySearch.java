package binarySearch;

public class BinarySearch {

    SVNRepo s = new SVNRepo(4);

    public int classicSearch(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, h = nums.length-1;
        int mid;
        while(l<=h){
            mid = ( l + h )/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return -1;
    }

    public int searchFirstPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, h = nums.length - 1;
        int mid;
        while (l < h) {
            mid = (l + h) / 2;
            if (nums[mid] == target) {
                h = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        if (nums[l] == target) return l;
        else return -1;
    }

    public int searchLastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, h = nums.length - 1;
        int mid;
        while (l < h) {
            mid = (l + h) / 2;
            if (nums[mid] == target) {
                if(nums[mid + 1] != target){
                    return mid;
                }
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        if (nums[h] == target) return h;
        else return -1;
    }


    public int findFirstBadVersionV1(int n) {
        // write your code here
        if (n == 0) {
            return -1;
        }
        int l = 1, h = n;
        int mid;
        while (l < h) {
            mid = (l + h) / 2;
            if (s.isBadVersion(mid)) {
                if (!s.isBadVersion(mid - 1)){
                    return mid;
                }
                h = mid - 1 ;
            }
            else{
                if(!s.isBadVersion(h - 1)){
                    return h;
                }
                l = mid + 1;
            }

        }
        return l;
    }

    public int findFirstBadVersionV2(int n) {
        // write your code here
        if (n == 0) {
            return -1;
        }
        int l = 1, h = n;
        int mid;
        while (l +1 < h) {
            mid = (l + h) / 2;
            if (s.isBadVersion(mid)) {
                h = mid;
            }
            else{
                l = mid;
            }

        }
        if(s.isBadVersion(l)){
            return l;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,2,4,5,5};
        int target = 2;

        BinarySearch bs = new BinarySearch();
        System.out.println(bs.classicSearch(nums, target));
        System.out.println(bs.searchFirstPosition(nums, target));
        System.out.println(bs.searchLastPosition(nums, target));
        System.out.println(bs.findFirstBadVersionV1(5));
        System.out.println(bs.findFirstBadVersionV2(5));
    }
}

