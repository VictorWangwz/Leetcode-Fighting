//731. My Calendar II

import java.util.TreeMap;

public class MyCalendarTwo {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int count = 0;
        for(int val: calendar.values()){
            count += val;
            if(count >= 3){
                calendar.put(start, calendar.get(start) - 1);
                calendar.put(end, calendar.get(end) + 1);
                return false;
            }
        }
        return true;

    }
}
