package cc.BitManipulation;
//190. Reverse Bits
public class ReverseBits {
    public int reverseBits(int n) {
        int rst = 0;
        for(int i = 0; i < 32; i++){
            int tmp = n & 1;
            n >>= 1;
            rst += (tmp << (32-i -1));
        }
        return rst;
    }
}
