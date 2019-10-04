package trie;
//421. Maximum XOR of Two Numbers in an Array
public class MaximumXORofTwoNumbersinanArray {
    private final int INT_SIZE = 32;
    public int findMaximumXOR(int[] nums) {

        Node root = new Node();
        for(int num: nums){
            insert(root, num);
        }

        return findMaxXOR(root.zero, root.zero);

    }

    public int findMaxXOR(Node n1, Node n2){
        if(n1 == null || n2 == null){
            return 0;
        }
        if(n1.value != -1 && n2.value != -1){
            return n1.value ^ n2.value;
        }

        int max = Math.max(findMaxXOR(n1.zero, n2.one), findMaxXOR(n1.one, n2.zero));
        if(max == 0) max = Math.max(findMaxXOR(n1.zero, n2.zero), findMaxXOR(n1.one, n2.one));
        return max;
    }

    public void insert(Node root, int num){
        int[] values = new int[INT_SIZE];
        for( int i = 0, j = num; i < INT_SIZE; i++, j >>= 1){
            values[i] = j & 1;
        }

        for( int i = INT_SIZE - 1; i >= 0; i--){
            if(values[i] == 0){
                if(root.zero == null) root.zero = new Node();
                root = root.zero;
            }
            else {
                if(root.one == null) root.one = new Node();
                root = root.one;
            }
        }
        root.value = num;
    }

    class Node{

        public int value;
        public Node zero;
        public Node one;
        public Node(){
            value = -1;
            zero = null;
            one = null;
        }

    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        MaximumXORofTwoNumbersinanArray maximumXORofTwoNumbersinanArray = new MaximumXORofTwoNumbersinanArray();
        int rst = maximumXORofTwoNumbersinanArray.findMaximumXOR(nums);
        System.out.println( rst);
    }
}
