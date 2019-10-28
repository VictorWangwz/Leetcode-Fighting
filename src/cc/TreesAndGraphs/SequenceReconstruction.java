package cc.TreesAndGraphs;

import java.util.*;
//todo
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> allInt = new HashSet<>();

        for(List<Integer> seq: seqs){
            if(!map.containsKey(seq.get(0))){
                map.put(seq.get(0), new HashSet<>());
            }
            map.get(seq.get(0)).add(seq.get(1));
            allInt.add(seq.get(0));
            allInt.add(seq.get(1));
        }


        Set<Integer> orgSet = new HashSet<>();
        for(int i: org){
            orgSet.add(i);
        }
        if(orgSet.size() != allInt.size()){
            return false;
        }
        if(orgSet.size() == 0){
            return true;
        }
        int cur = org[0];
        for(int i = 1; i < org.length; i++){
            if(map.containsKey(cur) && map.get(cur).contains(org[i])){
                cur = org[i];
                continue;
            }

            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] org = {4,1,5,2,6,3};
        int[][] seqArr = {{5,2,6,3},{4,1,5,2}};
        List<List<Integer>> seqs = new ArrayList<>();
        for(int[] arr: seqArr){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(arr[0]);
            tmp.add(arr[1]);
            seqs.add(tmp);
        }
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();

        boolean rst = sequenceReconstruction.sequenceReconstruction(org, seqs);
        System.out.println(rst);
    }


}
