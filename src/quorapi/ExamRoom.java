package quorapi;

import java.util.TreeSet;

//855. Exam Room
public class ExamRoom {
    TreeSet<Integer> seats;
    int num;

    public ExamRoom(int N) {
        seats = new TreeSet<>();
        num = N;
    }

    public int seat() {

        int rst = 0;
        if(seats.size() > 0){
            Integer prev = null;
            Integer d = seats.first();
            for(Integer seat: seats){
                if(prev != null){
                    if((seat - prev)/2 > d){
                        d = (seat - prev)/2;
                        rst = d + prev;
                    }

                }
                prev = seat;
            }
            if(num - 1 - seats.last() > d){
                rst = num - 1;
            }
        }

        seats.add(rst);
        return rst;
    }

    public void leave(int p) {
        seats.remove(p);
    }
}
