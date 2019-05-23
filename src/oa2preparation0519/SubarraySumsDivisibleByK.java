package oa2preparation0519;

public class SubarraySumsDivisibleByK {


//    public static int subarraysDivByK(int[] A, int K) {
//        List<List<Integer>> set = new ArrayList<>();
//        for(int i = 0; i < A.length; i++){
//            List<Integer> temp = new ArrayList<>();
//            int sum = 0;
//            for(int j = i; j < A.length; j++){
//                sum += A[j];
//                temp.add(j);
//                if(sum % K == 0){
//                    set.add(temp);
//                    temp = new ArrayList<>(temp);
//                }
//            }
//        }
//        return set.size();
//    }

    public static int subarraysDivByK(int[] A, int K) {

        int[] m = new int[K];
        m[0] = 1;
        int count = 0, sum = 0;
        for(int a: A){
            sum = (sum + a) % K;
            if(sum < 0) sum += K;
            count += m[sum];
            m[sum] ++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {4,5,0};
        int K = 5;
        int rst =  subarraysDivByK(A, K);
        System.out.println(rst);
    }

}
