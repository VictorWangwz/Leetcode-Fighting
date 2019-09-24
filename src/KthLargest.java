import java.util.Comparator;
import java.util.PriorityQueue;

//215
public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length == 0 || k > nums.length) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) return -1;
                else if(o1 < o2) return 1;
                else return 0;
            }
        });
        for(int i: nums){
            pq.offer(i);
        }
        int rst = 0;
        while(k > 0){
            rst = pq.poll();
            k = k - 1;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums ={3,2,1,5,6,4};
        int k = 2;
        int rst = findKthLargest(nums, k);
        System.out.println(rst);
    }
}
