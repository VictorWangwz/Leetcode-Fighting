package oa2preparation0519;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
    //Definition for a Record
    static class Record {
        public int id, score;
        public Record(int id, int score){
            this.id = id;
            this.score = score;
        }
     }

    public static Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> rst = new HashMap<>();
        Map<Integer, PriorityQueue<Record>> mpq = new HashMap<>();
        for (Record r : results) {
            if (!mpq.containsKey(r.id)) {
                mpq.put(r.id, new PriorityQueue<Record>(new Comparator<Record>() {
                    @Override
                    public int compare(Record o1, Record o2) {
                        return o1.score - o2.score; // min-heap
                    }
                }));
            }
            PriorityQueue<Record> pq = mpq.get(r.id);
            pq.add(r);
            if (pq.size() > 5) {
                pq.poll();
            }
        }
        for (Map.Entry<Integer, PriorityQueue<Record>> entry : mpq.entrySet()) {
            int id = entry.getKey();
            double sum = 0;
            int num = 0;
            PriorityQueue<Record> pq = entry.getValue();
            while (!pq.isEmpty()) {
                Record temp = pq.poll();
                sum += temp.score;
                num += 1;
            }
            rst.put(id, sum / num);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] results = {{1,91},{1,92},{2,93},{2,99},{2,98},{2,97},{1,60},{1,58},{2,100},{1,61}};
        Record[] records = new Record[results.length];
        for(int i = 0; i < results.length; i++){
            records[i] = new Record(results[i][0], results[i][1]);
        }
        Map<Integer, Double> rst = highFive(records);
        System.out.println(rst);
    }

}
