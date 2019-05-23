package oa2preparation0519;

import java.util.*;

public class AmazonFreshDelivery {

    public static List<List<Integer>> KClosetDestination(int numDestinations, List<List<Integer>> allLocations, int numDeliveries){
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                 int diff =  -o1.get(0) * o1.get(0) - o1.get(1) * o1.get(1)
                       + o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1);
//                 if(diff == 0)
//                     diff = o2.get(0) - o1.get(0);
//                 if(diff == 0)
//                     diff = o2.get(1) - o2.get(1);
                 return diff;
            }
        });
        for(int i = 0; i < allLocations.size(); i++){
            List<Integer> temp = allLocations.get(i);
            pq.offer(temp);
            while(pq.size() > numDeliveries){
                pq.poll();
            }
        }
        List<List<Integer>> temp_rst = new ArrayList<>();
        while(!pq.isEmpty()){
            temp_rst.add(pq.poll());
        }
        List<List<Integer>> rst = new ArrayList<>();
        int i = numDeliveries - 1;
        for (; i>=0; i--){
            rst.add(temp_rst.get(i));
        }
        return rst;
    }

    public static void main(String[] args) {
        int numDestinations = 3;
        List<List<Integer>> allLocations = new ArrayList<>();
        Integer[][] locations = {{1,2},{3,4},{1,-1}};
        for(Integer[] i: locations) allLocations.add(Arrays.asList(i));
        int numDeliveries = 2;
        List<List<Integer>> rst = KClosetDestination(numDestinations, allLocations, numDeliveries);
        System.out.println(rst);
    }
}
