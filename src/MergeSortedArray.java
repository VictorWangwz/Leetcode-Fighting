//88
import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray {
    static int[] nums1;
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> l = new ArrayList<>();
        int i = 0, j = 0;
        while(i  < m && j < n){
            if(nums1[i] > nums2[j]){
                l.add(nums2[j]);
                j++;
            }
            else{
                l.add(nums1[i]);
                i++;
            }
        }
        if(i == m){
            while(j < n){
                l.add(nums2[j++]);
            }
        }
        if(j == n){
            while(i < m){
                l.add(nums1[i++]);
            }
        }
        nums1 = new int[6];
        int x = 0;
        for(Integer k: l){
            nums1[x++] = k.intValue();
        }
        return;
    }

    public static void main(String[] args) {
        nums1 = new int[]{1,2,3};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(nums1);
    }
}
