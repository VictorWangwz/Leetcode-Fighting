package mergeInterval;

import java.util.*;


public class Merge_Interval {


    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0){
            return null;
        }
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 0; i<intervals.size(); i++){
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
        }

        int[] storage = new int[end-start+1];
        for(int i = 0; i<intervals.size(); i++){
            for(int j = intervals.get(i).start; j< intervals.get(i).end; j++){
                storage[j - start] = 1;
            }
        }
        List<Interval> res = new ArrayList<>();
        int s = -1;
        int e = 0;
        for (int i=0; i<storage.length; i++){
            if(storage[i] == 1){
                if(s == -1){
                    s = i;
                    e = i;
                }
                else{
                    e++;
                }
            }
            else{
                if(s!= -1){
                    Interval itv = new Interval(s+start, e+start+1);
                    res.add(itv);
                }

                s = -1;
            }
        }
        if (s != -1){
            Interval itv = new Interval(s+start, e+start);
            res.add(itv);
        }
        return res;
    }


//    private class IntervalComparator implements Comparator<Interval> {
//        @Override
//        public int compare(Interval a, Interval b){
//            return a.start < b.start? -1: a.start == b.start? 0: 1;
//        }
//    }
//
//    public List<Interval> merge(List<Interval> intervals) {
//        Collections.sort(intervals, new IntervalComparator());
//        List<Interval> res = new ArrayList<>();
//        for(int i = 0; i< intervals.size(); i++){
//            if(res.isEmpty() || res.get(res.size() - 1) .end <= intervals.get(i).start){
//                res.add(new Interval(intervals.get(i).start, intervals.get(i).end));
//            }
//            else{
//                Interval last = res.get(res.size() - 1);
//                res.remove(res.size() - 1);
//                res.add(new Interval(last.start, intervals.get(i).end));
//            }
//
//        }
//        return res;
//    }


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(5,6));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(15,18));
        Merge_Interval m = new Merge_Interval();
        System.out.println(m.merge(intervals));
    }
}
