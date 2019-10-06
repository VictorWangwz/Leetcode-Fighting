package cc.BitManipulation;
//461. Hamming Distance
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int rst = 0;
//        the same to use  Integer.bitCount
        while(z != 0){
            int tmp = z & 1 ;
            if( tmp == 1){
                rst ++;
            }
            z >>= 1;
        }
        return rst;
    }
}
