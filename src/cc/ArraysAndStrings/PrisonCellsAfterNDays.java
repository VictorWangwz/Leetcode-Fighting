package cc.ArraysAndStrings;

import java.util.*;
import java.util.stream.Collectors;

//957. Prison Cells After N Days
public class PrisonCellsAfterNDays {


    //Time limited exceeded
//    public int[] prisonAfterNDays0(int[] cells, int N) {
//        for(int i = 0; i <= N; i++){
//            cells = mutate(cells);
//        }
//        return cells;
//    }


    //Time limited exceeded? why//todo
    private List<Integer> helper(List<Integer> cells, int N){
        if(!flag){
            StringBuffer sb = new StringBuffer();
            for(Integer i: cells){
                sb.append(i);
            }
            if(l1.contains(sb.toString())){
                flag = true;
            }
            else{
                l1.add(sb.toString());
                l2.add(mutate(cells));
            }
            int idx = l1.indexOf(sb.toString());
            return l2.get(idx);
        }
        else{
            int idx = ((N - 2) % l1.size());
            return l2.get(idx);
        }

    }

    private List<Integer> mutate(List<Integer> cs){
        List<Integer> cells = new ArrayList<>();
        cells.addAll(cs);
        if(cells == null && cells.size() == 0){
            return cells;
        }
        boolean[] help = new boolean[cells.size()];

        for( int i = 1; i < cells.size() - 1; i++){
            if((cells.get(i - 1) == 0 && cells.get(i + 1) == 0) || (cells.get(i - 1) == 1 && cells.get(i + 1) == 1)){
                help[i] = true;
            }
        }
        for( int i = 0; i < cells.size(); i++){
            if(help[i] == false){
                cells.set(i, 0);
            }
            else{
                cells.set(i, 1);
            }
        }
        return cells;
    }

    private List<String> l1 = new ArrayList<>();
    private List<List<Integer>> l2 = new ArrayList<>();

    private boolean flag = false;
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(N == 0){
            return cells;
        }
        List<Integer> newCells = Arrays.stream(cells).boxed().collect(Collectors.toList());
        newCells = mutate(newCells);
        if(N == 1){
            return newCells.stream().mapToInt(i -> i).toArray();
        }
        List<Integer> tmp = newCells;
        for(int i = 2; i <= N; i++){

            tmp = helper(newCells, i);
            newCells = tmp;
        }
        return newCells.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int N = 100;
        PrisonCellsAfterNDays prisonCellsAfterNDays = new PrisonCellsAfterNDays();
        int[] rst = prisonCellsAfterNDays.prisonAfterNDays(cells, N);
        System.out.println(rst);
    }
}
