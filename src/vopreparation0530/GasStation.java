package vopreparation0530;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0, index = 0, subRes = Integer.MAX_VALUE;
        for(int i = 0; i < gas.length; i++){
            res += gas[i] - cost[i];
            if(res < subRes){
                subRes = res;
                index = i + 1;
            }
        }
        return res >= 0? index % gas.length: -1;
    }

    public static void main(String[] args) {
        int[] gas  = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int rst = canCompleteCircuit(gas, cost);
        System.out.println(rst);
    }
}
