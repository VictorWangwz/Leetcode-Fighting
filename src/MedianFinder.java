import java.util.Comparator;
import java.util.PriorityQueue;

//295
class MedianFinder {
    int size;
    int[] data;
    PriorityQueue<Integer> pqLower;
    PriorityQueue<Integer> pqHigher;
    /** initialize your data structure here. */
    public MedianFinder() {
        size = 0;
//        data = new int[0];
        pqHigher = new PriorityQueue<>();
        pqLower = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
//        int[] newData = new int[size + 1];
//        System.arraycopy(data, 0, newData, 1, size);
//        newData[0] = num;
//        Arrays.sort(newData);
//        data = newData;
        if(size == 0){
            pqLower.offer(num);
            size++;
            return;
        }
        if(size % 2 == 0){
            if(pqHigher.peek() < num){
                pqLower.offer(pqHigher.poll());
                pqHigher.offer(num);
            }
            else{
                pqLower.offer(num);
            }
        }
        else{
            if(pqLower.peek() > num){
                pqHigher.offer(pqLower.poll());
                pqLower.offer(num);
            }
            else{
                pqHigher.offer(num);
            }
        }

        size++;

    }

    public double findMedian() {
        if(size == 0)
            return 0.0;
        if(size % 2 == 1){
            return pqLower.peek();

//            return data[size/2];
        }
        else{
            return (pqLower.peek() + pqHigher.peek()) / 2.0;
//            return (data[size/2 - 1] + data[size/2])/2.0;
        }

    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(10);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(5);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());


    }
}
