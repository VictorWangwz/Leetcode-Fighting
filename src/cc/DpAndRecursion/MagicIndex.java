package cc.DpAndRecursion;
//Magic Index: A magic index in an array A [ 0 ••• n -1] is defined to be an index such that A[ i] =
//i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
//array A.
public class MagicIndex {


    public int findMagicIndex(int[] A){
        int l = 0, r = A.length - 1;
        while(l < r){
            int mid = ( l + r ) / 2;
            if(A[mid] == mid){
                return mid;
            }
            else if( A[mid] > mid){
                r = mid + 1;
            }
            else{
                l = mid - 1;
            }
        }
        return -1;
    }
}
