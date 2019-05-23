package oa2preparation0519;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KNearestPoints {
    public static class Point {
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
                return -o1.x * o1.x - o1.y * o1.y + o2.x * o2.x + o2.y * o2.y;
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
    public static Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                int diff =   - (p1.x - origin.x) * (p1.x - origin.x) - (p1.y - origin.y) * (p1.y - origin.y) + (p2.x - origin.x) * (p2.x - origin.x) + (p2.y - origin.y) * (p2.y - origin.y);
                if(diff == 0) {
                    diff = p2.x - p1.x;
                }
                if (diff == 0) {
                    diff = p2.y - p1.y;
                }
                return diff;
            }
        });
        for(int i = 0; i< points.length; i++){
            pq.add(points[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        Point[] rst = new Point[k];
        int i = 0;
        while(!pq.isEmpty()){
            rst[k - i - 1] = pq.poll();
            i++;
        }
        return rst;
    }

    public static void main(String[] args) {
        int k = 1;
        Point origin = new Point(3, 1);
        int[][] points = {{ 0,0},{0,9}};
        Point[] p = new Point[2];
        int i = 0;
        for(; i < p.length; i++){
            p[i] = new Point(points[i][0], points[i][1]);
        }
        Point[] rst = kClosest(p, origin, 1);
        System.out.println(rst);
    }

}
