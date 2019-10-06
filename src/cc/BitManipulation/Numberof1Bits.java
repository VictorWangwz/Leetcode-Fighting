package cc.BitManipulation;
//191. Number of 1 Bits
public class Numberof1Bits {

    //time limited exceeded
//    public int hammingWeight(int n) {
//        int rst = 0;
//        while(n != 0){
//            if((n & 1) == 1){
//                rst ++;
//            }
//            n >>= 1;
//        }
//        return rst;
//    }

    // n & n-1 => get the second least important 1
    public int hammingWeight(int n) {
        int rst = 0;
        while(n != 0){
            if((n & 1) == 1){
                rst ++;
            }
            n >>= 1;
        }
        return rst;
    }
}
