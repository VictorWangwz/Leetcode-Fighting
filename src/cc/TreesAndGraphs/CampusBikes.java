package cc.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1057. Campus Bikes
public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] rst = new int[workers.length];
        boolean[] usedW = new boolean[workers.length], usedB = new boolean[bikes.length];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < bikes.length; i++){
            map.put(i, new ArrayList<>());
            for(int j = 0; j < workers.length; j++){
                map.get(i).add(Math.abs(workers[j][0] - bikes[i][0]) + Math.abs(workers[j][1] - bikes[i][1]) );
            }
        }

        int assigned = 0;
        while(assigned < workers.length){
            int min = Integer.MAX_VALUE;
            int chosenBike = 0;
            int chosenWorker = 0;
            for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
                if(!usedB[e.getKey()] ){
                    for(int k=0; k<e.getValue().size();k++){
                        if(!usedW[k] &&e.getValue().get(k) < min){
                            chosenBike = e.getKey();
                            min = e.getValue().get(k);
                            chosenWorker = k;
                        }
                    }
                }
            }
            usedB[chosenBike] = true;
            usedW[chosenWorker] = true;
            rst[chosenWorker] = chosenBike;
            assigned++;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] workers = {{0,0},{2,1}};
        int[][] bikes = {{1,2},{3,3}};
        CampusBikes campusBikes = new CampusBikes();
        int[] rst = campusBikes.assignBikes(workers, bikes);
        System.out.println(rst);
    }

}
