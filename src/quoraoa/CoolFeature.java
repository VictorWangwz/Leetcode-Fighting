package quoraoa;
//Give three array a, b and query. This one is hard to explain. Just read the example.
//Input:
//a = [1, 2, 3]
//b = [3, 4]
//query = [[1, 5], [1, 1 , 1], [1, 5]]
// Output:
//[2, 1]

import java.util.ArrayList;
import java.util.List;

public class CoolFeature {

    private int countTarget(int[] a, int[] b, int target){
        int rst = 0;
        for(int A: a){
            for(int B: b){
                if(A + B == target){
                    rst ++;
                }
            }
        }
        return rst;
    }

    public List<Integer> findFeature(int[] a, int[] b, int[][] query){
        List<Integer> rst = new ArrayList<>();
        for(int[] list: query){
            if(list.length == 2){
                int target = list[1];
                int record = countTarget(a, b, target);
                rst.add(record);
            }
            else if(list.length == 3){
                b[list[1] - 1] = list[2];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int [] a = {1, 2, 3}, b = {3, 4};
        int[][] query = {{1, 5}, {1, 1 , 1}, {1, 5}};
        CoolFeature coolFeature = new CoolFeature();
        List<Integer> rst = coolFeature.findFeature(a, b, query);
        System.out.println(rst);
    }
}
