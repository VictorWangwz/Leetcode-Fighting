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

    public int findMinInRotatedSortedArray(int[] nums){
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, h = nums.length-1, mid;
        int target = nums[nums.length - 1];
        while(l + 1 < h){
            mid = (l + h) /2;
            if(nums[mid] <= target){
                h = mid;
            }
            else{
                l = mid;
            }
        }
        return Math.min(nums[l], nums[h]);
    }

    public boolean searchIn2DMatrix(int[][] nums, int target){
        if(nums == null || nums.length == 0){
            return false;
        }
        int m = nums.length - 1, n = nums[0].length - 1;
        int l = 0, h = m, mid;
        while(l + 1<h){
            if( target >= nums[h][0]){
                l = h;
                break;
            }
            mid = (l + h)/2;
            if(nums[mid][0] <= target){
                l = mid;
            }
            else {
                h = mid;
            }
        }
        int row = l;
        if(nums[h][0] <= target) row = h;
        l = 0;
        h = n;
        while(l <= h){
            mid = (l + h)/2;
            if(nums[row][mid] == target){
                return true;
            }
            else if (nums[row][mid] < target){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return false;

    }

    public int searchIn2DMatrixForOccurance(int[][] nums, int target){
        if(nums == null || nums.length == 0 || nums[0].length == 0){
            return 0;
        }
        int m = nums.length - 1, n = nums[0].length - 1;
        int l = 0, h = m, mid;
        while(l + 1<h){
            if( target >= nums[h][0]){
                l = h;
                break;
            }
            mid = (l + h)/2;
            if(nums[mid][0] <= target){
                l = mid;
            }
            else {
                h = mid;
            }
        }
        int row = l;
        if(nums[h][0] <= target) row = h;
        int oc = 0;
        for(int i = 0; i<=row; i++){
            l = 0;
            h = n;
            while(l <= h){
                mid = (l + h)/2;
                if(nums[i][mid] == target){
                    oc ++;
                    l = mid + 1;
                }
                else if (nums[i][mid] < target){
                    l = mid + 1;
                }
                else{
                    h = mid - 1;
                }
            }
        }
        return oc;
    }


    public int[] searchRange(int[] nums, int target){
        int[] rst = new int[2];
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0, h = nums.length - 1;
        int mid = (l + h)/2;
        // Search first position
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
        if (nums[l] == target) rst[0] = l;
        else rst[0] = -1;

        l = 0;
        h = nums.length - 1;
        // Search last position
        while (l < h) {
            mid = (l + h) / 2;
            if (nums[mid] == target) {
                if(nums[mid + 1] != target){
                    rst[1] = mid;
                    break;
                }
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        if(rst[1] != mid){
            if (nums[h] == target) rst[1] = h;
            else rst[1] = -1;
        }
        return rst;
    }

    public int findMountTop(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, h = nums.length-1, mid;
        while(l + 1 < h){
            mid = (l+h)/2;
            if(nums[mid] < nums[mid + 1]){
                l = mid;
            }
            else{
                h = mid;
            }
        }
        return Math.max(nums[l], nums[h]);
    }

    public int findPeakElement(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, h = nums.length-1, mid;
        while(l + 1 < h){
            mid = (l+h)/2;
            if(nums[mid] < nums[mid + 1]){
                l = mid;
            }
            else {
                h = mid;
            }
        }
        return nums[l]>nums[h]?l:h;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 4, 5, 7, 6};
        int[] rotateNum = {1,2,3,4,5};
        int target = 7;
        int[][] matrix = {
                {1, 3, 5, 7},
                {2, 4, 7, 8},
                {3, 5, 9, 10}
    };

        BinarySearch bs = new BinarySearch();
//        System.out.println(bs.classicSearch(nums, target));
//        System.out.println(bs.searchFirstPosition(nums, target));
//        System.out.println(bs.searchLastPosition(nums, target));
//        System.out.println(bs.findFirstBadVersionV1(5));
//        System.out.println(bs.findFirstBadVersionV2(5));
//        System.out.println(bs.findMinInRotatedSortedArray(rotateNum));
//        System.out.println(bs.searchIn2DMatrix(matrix, target));
//        System.out.println(bs.searchIn2DMatrixForOccurance(matrix, target));
//        System.out.println(Arrays.toString(bs.searchRange(nums, target)));
//        System.out.println(bs.findMountTop(nums));
        System.out.println(bs.findPeakElement(nums));
    }
}

