import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//todo
//1130. Minimum Cost Tree From Leaf Values
public class MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int rst = 0;
        if(arr == null || arr.length <= 1){
            return rst;
        }

        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i: arr){
            pq.offer(i);
        }

        while(!pq.isEmpty()){
            if(pq.size() == 1){
                break;
            }
            int i1 = pq.poll(), i2 = pq.poll();
            rst += i1 * i2;
            pq.offer(i1 * i2);
        }
        return rst;
    }
}
