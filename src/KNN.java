import java.util.Arrays;

public class KNN {
    public int[][] kClosest(int[][] points, int K) {
//        List<Integer> dist = new ArrayList<Integer>(points.length);
//        for(int i = 0; i<points.length; i++){
//            int[] point = points[i];
//            dist.add(point[0]*point[0] + point[1]*point[1]);
//        }
//        int[][] res = new int[K][];
//        for(int i = 0; i<K; i++){
//            Integer min = Collections.min(dist);
//            res[i] = points[dist.indexOf(min)];
//            dist.set(dist.indexOf(min), Integer.MAX_VALUE);
//        }
//        return res;
        if(K <= 0 || points.length < K){
            return new int[0][];
        }
        int[] dist = new int[points.length];
        for(int i = 0; i<points.length; i++){
            int[] point = points[i];
            dist[i] = (point[0]*point[0] + point[1]*point[1]);
        }
        Arrays.sort(dist);
        int threshold = dist[K-1];
        int[][] res = new int[K][2];
        int j = 0;
        for(int i = 0; i<points.length; i++){
            int[] point = points[i];
            if(point[0]*point[0] + point[1]*point[1]<=threshold) {
                res[j++] = point;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KNN k = new KNN();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;
        System.out.println(k.kClosest(points, K));
    }
}
