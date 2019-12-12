package cc.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinAreaRect {

    public int minAreaRect(int[][] points) {
        if(points == null ||points.length < 4){
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> selected = new ArrayList<>();
        for(int[] point: points){
            if(!map.containsKey(point[0])){
                map.put(point[0], new ArrayList<>());
            }
            map.get(point[0]).add(point[1]);
            if(map.get(point[0]).size() == 2){
                selected.add(point[0]);
            }
        }
        if(selected.size() < 2){
            return 0;
        }
        int rst = Integer.MAX_VALUE;
        for(int i = 0; i < selected.size(); i++){
            List<Integer> pair1 = map.get(selected.get(i));
            for(int j = i + 1; j < selected.size(); j++){
                List<Integer> pair2 = map.get(selected.get(j));
                for(int m = 0; m < pair1.size(); m++){
                    if(pair2.contains(pair1.get(m))){
                        for(int n = m + 1; n < pair1.size(); n++){
                            if(pair2.contains(pair1.get(n))){
                                int space = Math.abs((pair1.get(m) - pair1.get(n)) * (selected.get(i) - selected.get(j)));
                                if(space < rst){
                                    rst = space;
                                }
                            }
                        }
                    }

                }
            }
        }
        if(rst == Integer.MAX_VALUE){
            return 0;
        }
        return rst;


    }

    public static void main(String[] args) {
        MinAreaRect minAreaRect = new MinAreaRect();
        int[][] points = {
                {1,1},{1,3},{3,1},{3,3},{4,1},{4,3}
        };
        int rst =  minAreaRect.minAreaRect(points);
        System.out.println(rst);
    }
}
