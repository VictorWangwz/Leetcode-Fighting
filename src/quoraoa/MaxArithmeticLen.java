package quoraoa;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxArithmeticLen {

    private boolean checkDiff(int diff, int[] a){
        for(int num: a){
            if((num - a[0]) % diff != 0){
                return false;
            }
        }
        return true;
    }

    public int countMaxArithLen(int[] a, int[] b){
        Set<Integer> set = IntStream.of(a).boxed().collect(Collectors.toSet());
        if(set.size() != a.length && set.size() != 1){
            return -1;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> diffs = new ArrayList<>();
        if(a.length > 1 && checkDiff(a[1]- a[0], a)){
            diffs.add(a[1] - a[0]);
        }

        int r = a.length > 1? a[1] : Integer.MAX_VALUE;

        for(int num: b){
            if(num > a[0] && num < r){
                if(checkDiff(num - a[0], a)) {
                    diffs.add(num - a[0]);
                }
            }
            if(num >= r){
                break;
            }
        }

        if(diffs.size() == 0){
            return  - 1;
        }

        Set<Integer> setB = IntStream.of(b).boxed().collect(Collectors.toSet());
        int maxInsertNum = -1;

        int min = Math.min(a[0], b[0]), max = Math.max(a[a.length - 1], b[b.length - 1]);
        searchDiff: for(int diff: diffs){
            int start = a[0] - diff * (a[0] - min) / diff;
            int end = a[0] + diff * (max - a[0]) / diff;

            int endIdx = (a[a.length - 1] - a[0]) / diff;
            int insertNum = 0;
            for(int i = 0; i < endIdx; i++){
                if(!set.contains(a[0] + i * diff) ){
                    if(!setB.contains(a[0] + i * diff))
                        continue searchDiff;
                    else{
                        insertNum++;
                    }
                }
            }
            int idx = 1;
            while(a[0] - idx * diff >= start){
                int tmp = a[0] - idx * diff;
                if(!set.contains(tmp) && setB.contains(tmp)){
                    insertNum++;
                }
                else{
                    break;
                }
                idx++;
            }
            idx = 1;
            while(a[a.length - 1] + idx * diff <= end){
                int tmp = a[a.length - 1] + idx * diff ;
                if(!set.contains(tmp) && setB.contains(tmp)){
                    insertNum++;
                }
                else{
                    break;
                }
                idx++;
            }
            if(maxInsertNum < insertNum){
                maxInsertNum = insertNum;
            }

        }
        return maxInsertNum;



    }

    public static void main(String[] args) {
        int[] a = {0,8,12,16};
        int[] b = {0,2,4,12,14,20};
//        int[] b = {5,7,9};
//        int[] a = {1,3,9,11,13};
        MaxArithmeticLen maxArithmeticLen = new MaxArithmeticLen();
        int rst = maxArithmeticLen.countMaxArithLen(a, b);
        System.out.println(rst);
    }
}
