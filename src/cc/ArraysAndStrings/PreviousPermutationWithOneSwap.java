package cc.ArraysAndStrings;
//1053. Previous Permutation With One Swap
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] A) {
        for(int i = A.length - 2; i >= 0; i--){
            if(A[i] > A[i+1]){
                for(int j = A.length - 1; j > i; j--){
                    int jVal = A[j];
                    if(A[i] > A[j]){
                        while(j-1 > i && A[j-1] == jVal){
                            j--;
                        }
                        int tmp = A[i];
                        A[i] = A[j];
                        A[j] = tmp;
                        return A;
                    }
                }
            }
        }
        return A;
    }
}
