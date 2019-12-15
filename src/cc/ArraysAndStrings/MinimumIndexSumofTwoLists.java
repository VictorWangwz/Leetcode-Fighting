package cc.ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

//599. Minimum Index Sum of Two Lists
public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> choices = new HashSet<>();
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < list1.length; i++){
            for(int j = 0; j < list2.length; j++){
                if(list1[i].equals(list2[j])){
                    if(i + j == sum){
                        choices.add(list1[i]);
                    }
                    else if(i + j < sum){
                        choices.clear();
                        sum = i + j;
                        choices.add(list1[i]);
                    }
                    break;
                }
            }
        }
        String[] rst = new String[choices.size()];
        int i = 0;
        for(String s: choices){
            rst[i++] = s;
        }
        return rst;

    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"},
                list2 = {"KFC", "Shogun", "Burger King"};
        MinimumIndexSumofTwoLists minimumIndexSumofTwoLists = new MinimumIndexSumofTwoLists();
        String[] rst = minimumIndexSumofTwoLists.findRestaurant(list1, list2);
        System.out.println(rst);
    }
}
