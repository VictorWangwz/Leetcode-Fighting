package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//912. Sort an Array
public class SortAnArray {

    //quick sort
    private int partition(int[] nums, int l, int h){

        int pivot = h;
        for(int i = l; i < h; i++){
            if(nums[i] < nums[pivot]){
                int tmp = nums[i];
                nums[i] = nums[l];
                nums[l] = tmp;
                l++;
            }
        }
        int tmp = nums[h];
        nums[h] = nums[l];
        nums[l] = tmp;
        return l;
    }

    private void quickSort(int[] nums, int l, int h){
        if(l < h){
            int pi = partition(nums, l, h);
            quickSort(nums, l, pi - 1);
            quickSort(nums, pi + 1, h);

        }
    }

    //merge sort
    private int[] merge(int[] left, int[] right){
        int[] nums = new int[left.length + right.length];
        int pl = 0, pr = 0, cur = 0;
        while(pl < left.length && pr < right.length){
            if(left[pl] < right[pr]){
                nums[cur++] = left[pl++];
            }else{
                nums[cur++] = right[pr++];
            }
        }
        while(pl < left.length){
            nums[cur++] = left[pl++];
        }
        while(pr < right.length){
            nums[cur++] = right[pr++];
        }
        return nums;
    }

    private int[] mergeSort(int[] nums, int l, int h){
        if(l >= h){
            int[] rst = {nums[l]};
            return rst;
        }
        int mid = (l + h) >> 1;
        int[] left = mergeSort(nums, l, mid);
        int[] right = mergeSort(nums, mid + 1, h);
        return merge(left, right);
    }


    //heap sort
    private void sink(int[] nums, int i, int n){
        while(2* (i + 1) - 1 < n){
            int left = 2 * (i + 1) - 1;
            int maxIdx = left;
            if(left + 1 < n && nums[left + 1] > nums[left]){
                maxIdx = left + 1;
            }
            if(nums[i] > nums[maxIdx]) {
                break;
            }
            swap(nums, i, maxIdx);
            i = maxIdx;

        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public List<Integer> sortArray(int[] nums) {
        int n = nums.length;
        for(int i = n/2 - 1; i >=0; i--){
            sink(nums, i, n);
        }

        while(--n > 0){
            swap(nums, 0, n);
            sink(nums, 0, n);
        }

        List<Integer> rst = new ArrayList<>();
        for(int num: nums){
            rst.add(num);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        SortAnArray sortAnArray = new SortAnArray();
        List<Integer> rst = sortAnArray.sortArray(nums);
        System.out.println(rst);
    }
}
