package oa2preparation0519;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KNearestPoints {
    public class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public List<Point> findKClosest(Point[] p, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x * o1.x + o1.y * o1.y - o2.x * o2.x + o2.y * o2.y;
            }
        });
        for(int i = 0; i < p.length; i++){
            if(i < k){
                pq.offer(p[i]);
            }
            else{
                Point temp = pq.peek();
                if(p[i].x * p[i].x + p[i].y * p[i].y < temp.x * temp.x + temp.y * temp.y){
                    pq.poll();
                    pq.offer(p[i]);
                }
            }
        }
        List<Point> rst = new ArrayList<>();
        while(!pq.isEmpty()){
            rst.add(pq.poll());
        }
        return rst;
    }

}
