package cc.BitManipulation;
//231. Power of Two
//x & (-x) will maintain the rightmost 1 and set all others to 0;
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        long x = (long) n;
        return (x &(-x)) == x;
    }
}
