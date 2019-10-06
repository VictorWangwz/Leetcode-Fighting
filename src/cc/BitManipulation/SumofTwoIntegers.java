package cc.BitManipulation;
//371. Sum of Two Integers

//Add two integer: sum without no carry: ^, carry: a & b then <<, rst(recursive): carry + sum until carry == 0
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        while(a != 0){
            int carry = a & b;
            b = a ^ b;
            a = carry << 1;

        }
        return b;
    }
}
