package cc.ArraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//4. Median of Two Sorted Arrays
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int n = len1 + len2;
        int[] nums = new int[n];
        int i = 0;
        for(; i < len1; i++){
            nums[i] = nums1[i];
        }
        for(; i < n; i++){
            nums[i] = nums2[i - len1];
        }
        Arrays.sort(nums);
        if(n % 2 == 1){
            return nums[n / 2];
        }
        else{
            return (double)(nums[(n - 1) / 2] + nums[(n + 1) / 2]) / 2.0;
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        PriorityQueue<Integer> pql = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> pqh = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int m = nums1.length, n = nums2.length;
        if(m + n == 0){
            return 0;
        }
        helper(pql, pqh, m, n,  nums1);
        helper(pql, pqh, n, m, nums2);
        if( (m + n) % 2 == 1){
            return pqh.peek();
        }
        else{
            return (double)(pqh.peek() + pql.peek()) / 2.0;
        }


    }

    private void helper(PriorityQueue<Integer> pql, PriorityQueue<Integer> pqh, int m, int n, int[] nums){
        for(int i = 0; i < m; i++){
            if(pql.size() == (m + n) / 2 ){
                if(pql.size() == 0 || pql.peek() < nums[i]){
                    pqh.offer(nums[i]);
                }
                else{
                    pqh.offer(pql.poll());
                    pql.add(nums[i]);
                }
            }
            else{
                pql.offer(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {3}, nums2 = {-2,-1};
        MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays();
        double rst = medianofTwoSortedArrays.findMedianSortedArrays1(nums1, nums2);
        System.out.println(rst);
    }
}
