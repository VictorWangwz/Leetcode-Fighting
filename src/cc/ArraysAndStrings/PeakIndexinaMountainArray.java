package cc.ArraysAndStrings;
//852. Peak Index in a Mountain Array
public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        for(int i = 0; i < A.length - 1; i++){
            if(A[i] > A[i + 1]){
                return i;
            }
        }
        return -1;
    }
}
