package googleoa;

//1007. Minimum Domino Rotations For Equal Row
public class MinDominoRotation {

    public static int checkDomino(int key, int[] A, int[] B){
        int n = A.length;
        int countA = 0, countB = 0;
        for(int i = 0; i < n; i++){
            if(A[i] != key && B[i] != key){
                return -1;
            }else if( A[i] != key){
                countA += 1;
            }
            else if( B[i] != key){
                countB += 1;
            }
        }
        return Math.min(countA, countB);
    }


    public static int minDominoRotations(int[] A, int[] B) {

        int rstA = checkDomino(A[0], A, B);
        if(rstA != -1 || A[0] == B[0]) return rstA;
        else return checkDomino(B[0], A, B);

    }

    public static void main(String[] args) {
        int[] A = {1,2,1,1,1,2,2,2},
                B = {2,1,2,2,2,2,2,2};
        System.out.println(minDominoRotations(A, B));
    }
}
