import java.util.*;

//264
public class UglyNumber2 {
    public int nthUglyNumber(int n) {

        if(n <= 0) return 0;
        if(n == 1) return 1;
        Long uglyNumber = new Long(1);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(new Long(2));
        pq.add(new Long(3));
        pq.add(new Long(5));
        int rst = 1;
        while(rst < n){
            uglyNumber = pq.poll();
            if(!pq.contains(uglyNumber * 2) ){
                pq.add(uglyNumber * new Long(2));
            }
            if(!pq.contains(uglyNumber * 3)){
                pq.add(uglyNumber * new Long(3));
            }
            if(!pq.contains(uglyNumber * 5)){
                pq.add(uglyNumber * new Long(5));
            }
            rst++;
        }
        return uglyNumber.intValue();
    }

//    public static int nthUglyNumber(int n) {
//        if(n <= 0) return 0;
//        if(n == 1) return 1;
//        Map<Integer, Boolean> m = new HashMap<>();
//        int uglyNumber = 1;
//        m.put(uglyNumber, true);
//        uglyNumber++;
//        int rst = 1;
//        while(rst < n){
//            m.put(uglyNumber, false);
//            if(uglyNumber % 2 == 0 && m.getOrDefault(uglyNumber/2, false)){
//                m.put(uglyNumber, true);
//                rst++;
//            }
//            else if(uglyNumber % 3 == 0 && m.getOrDefault(uglyNumber/3, false)){
//                m.put(uglyNumber, true);
//                rst++;
//            }
//            else if(uglyNumber % 5 == 0 && m.getOrDefault(uglyNumber/5, false)){
//                m.put(uglyNumber, true);
//                rst++;
//            }
//            uglyNumber++;
//        }
//        return uglyNumber-1;
//
//    }

    public static void main(String[] args) {
        int n = 1600;
        UglyNumber2 u = new UglyNumber2();
        int rst = u.nthUglyNumber(n);
        System.out.println(rst);
    }
}
