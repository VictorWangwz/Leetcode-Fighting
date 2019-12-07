package cc.ArraysAndStrings;

import java.util.Comparator;
import java.util.PriorityQueue;

//1167. Minimum Cost to Connect Sticks
public class MinimumCosttoConnectSticks {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int stick: sticks){
            pq.offer(stick);
        }
        int rst = 0;
        while(pq.size() > 1){
            int i1 = pq.poll();
            int i2 = pq.poll();
            rst += i1 + i2;
            pq.offer(i1 + i2);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] sticks = {
                2,4,3
        };
        MinimumCosttoConnectSticks minimumCosttoConnectSticks = new MinimumCosttoConnectSticks();
        int rst = minimumCosttoConnectSticks.connectSticks(sticks);
        System.out.println(rst);
    }
}
