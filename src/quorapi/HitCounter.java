package quorapi;

import java.util.ArrayList;
import java.util.List;

//362. Design Hit Counter
public class HitCounter {
    List<Integer> store;

    /** Initialize your data structure here. */
    public HitCounter() {
        store = new ArrayList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        store.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if(store.size() == 0){
            return 0;
        }
        int count = 0;
        for(Integer time: store){
            if(time <= timestamp && time > timestamp - 300){
                count++;
            }
        }
        return count;
    }
}
