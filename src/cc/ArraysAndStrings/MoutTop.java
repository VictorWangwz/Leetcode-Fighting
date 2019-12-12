package cc.ArraysAndStrings;

public class MoutTop {

    public boolean validMountainArray(int[] A) {
        if(A == null || A.length < 3){
            return false;
        }
        int top = 0;
        int i = 1;
        for(; i < A.length;i++){
            if(A[i] > A[i-1]){
                continue;
            }
            else{
                break;
            }
        }
        if( i== 1 ||i == A.length){
            return false;
        }
        top = i - 1;
        int j = top + 1;
        for(; j < A.length; j++){
            if(A[j] < A[j - 1]){
                continue;
            }
            else{
                break;
            }
        }
        if(j == A.length){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int[] A = {2,0,2};
        MoutTop moutTop = new MoutTop();
        boolean rst = moutTop.validMountainArray(A);
        System.out.println(rst);
    }
}
