package cc.ArraysAndStrings;
//66. Plus One
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while( i >= 0 ){
            digits[i] ++;
            if(digits[i] == 10){
                digits[i] = 0;
                i--;
            }
            else{
                return digits;
            }
        }
        int[] newD = new int[digits.length + 1];
        newD[0] = 1;
        return newD;
    }
}
