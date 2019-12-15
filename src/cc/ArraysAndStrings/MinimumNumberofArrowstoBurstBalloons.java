package cc.ArraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;

//452. Minimum Number of Arrows to Burst Balloons
public class MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if(points == null ||points.length == 0){
            return 0;
        }
        if(points.length == 1){
            return 1;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int rst = 1;
        int prevEnd = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > prevEnd){
                rst++;
                prevEnd = points[i][1];
            }
        }
        return rst;

    }

    public static void main(String[] args) {
        int[][] points = {
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };
        MinimumNumberofArrowstoBurstBalloons minimumNumberofArrowstoBurstBalloons = new MinimumNumberofArrowstoBurstBalloons();
        int rst = minimumNumberofArrowstoBurstBalloons.findMinArrowShots(points);
        System.out.println(rst);
    }
}
