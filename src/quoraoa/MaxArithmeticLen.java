package quoraoa;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxArithmeticLen {

    //todo
    public int countMaxArithLen(int[] a, int[] b){
        Set<Integer> set = IntStream.of(a).boxed().collect(Collectors.toSet());
        set.addAll(IntStream.of(b).boxed().collect(Collectors.toSet()));
        int[] ab = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(ab);

        int rst = Integer.MIN_VALUE;
        int[][] mem = new int[ab.length][ab.length];
        for(int i = 0; i < ab.length; i++){
            for(int j = i + 1; j < ab.length; j++){
                if(mem[i][j] == 0){
                    int diff = ab[j] - ab[i];
                    int start = i, end = j;
                    mem[i][j] = 2;
                    for(int k = j + 1; k < ab.length; k++){
                        if(ab[k] == ab[end] + diff){
                            mem[end][k] = mem[start][end] + 1;
                            start = end;
                            end = k;
                        }
                    }
                    int count = mem[start][end];
                    rst = count > rst ? count : rst;
                }

            }
        }
        return 1;


    }

    public static void main(String[] args) {
        int[] a = {0,4,8,16};
        int[] b = {0,2,6,12,14,16};
        MaxArithmeticLen maxArithmeticLen = new MaxArithmeticLen();
        int rst = maxArithmeticLen.countMaxArithLen(a, b);
        System.out.println(rst);
    }
}
