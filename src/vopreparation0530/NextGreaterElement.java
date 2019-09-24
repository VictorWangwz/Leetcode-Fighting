package vopreparation0530;

//Next Greater Element
//        Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.
//
//        Examples:
//        a) For any array, rightmost element always has next greater element as -1.
//        b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
//https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

    public static int[] printNGE(int arr[], int n){
        return new int[n];
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int n = 4;
        int[] rst = printNGE(arr, n);
        int[] expected = {5, 25, 25, -1};
        System.out.print(rst.equals(expected));
    }


}
