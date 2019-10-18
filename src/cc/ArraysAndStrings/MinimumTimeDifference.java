package cc.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//539. Minimum Time Difference
public class MinimumTimeDifference {

    private int calMin(String time){
        String[] str = time.split(":");
        int rst = 0;
        rst += 60 * Integer.valueOf(str[0]);
        rst += Integer.valueOf(str[1]);
        return rst;
    }

    private int calDiff(int time1, int time2){

        int fullTime = calMin("24:00");
        if(time1 < time2){
            int temp = time1;
            time1 = time2;
            time2 = temp;
        }

        int diff1 = time1 - time2;
        int diff2 = time2 + fullTime - time1;
        return Math.min(diff1, diff2);
    }

    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for(int i = 0; i < timePoints.size(); i++){
            times[i] = calMin(timePoints.get(i));
        }
        Arrays.sort(times);
        int rst = Integer.MAX_VALUE;
        for(int i = 1; i < times.length; i++){
            int tmp = calDiff(times[i], times[i - 1]) ;
            if(tmp < rst){
                rst = tmp;
            }
        }
        int tmp = calDiff(times[0], times[times.length - 1]);
        if(tmp < rst){
            rst = tmp;
        }

        return rst;

    }

    public static void main(String[] args) {
        MinimumTimeDifference minimumTimeDifference = new MinimumTimeDifference();
        String[] times = {"05:31","22:08","00:35"};
        List<String> timePoints = new ArrayList<>();
        for(String s: times){
            timePoints.add(s);
        }
        int rst = minimumTimeDifference.findMinDifference(timePoints);
        System.out.println(rst);
    }
}
