package oa2preparation0519;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AmazonPrimeAir {
//    Input
//      1. maximumOperatingTravelDistance, an integer representing the maximum operating travel distance of
//    the given aircraft.
//      2. forwardShipping RouteList, a list of pairs of integers where the first integer represents the unique
//    identifier of a forward shipping route and the second integeter represent the amount of travel distance
//    required by shipping route
//      3. returnShippingRouteList, a list of pairs of integers where the first integer represents the unique
//    identifier of a forward shipping route and the second integeter represent the amount of travel distance
//    required by shipping route

//    output
//    Return a list of pairs of integer representing the pairs of IDs of forward and return shipping routes that
//    optimal utilize the given aircraft. If no route is possible, return an empty list.

    public static List<List<Integer>> flight(
            int maximumOperatingTravelDistance,
            List<List<Integer>> forwardShipping,
            List<List<Integer>> returnShippingRouteList){
        List<List<Integer>> rst = new ArrayList<>();
        if(
                forwardShipping == null
                || returnShippingRouteList == null
                || forwardShipping.size() == 0
                || returnShippingRouteList.size() == 0){
            return rst;
        }

        Collections.sort(forwardShipping, (l1, l2)->{
            if(l1.get(1) == l2.get(1)) return 0;
            return l1.get(1) - l2.get(1);
        });
        Collections.sort(returnShippingRouteList, (l1, l2)->{
            if(l1.get(1) == l2.get(1)) return 0;
            return l1.get(1) - l2.get(1);
        });
        int pt1 = 0, pt2 = returnShippingRouteList.size() - 1;
        int closest = Integer.MAX_VALUE;
        while(pt1 < forwardShipping.size() && pt2 >= 0){
            List<Integer> forwardPt = forwardShipping.get(pt1);
            List<Integer> returnPt = returnShippingRouteList.get(pt2);
            int diff = maximumOperatingTravelDistance
                    - forwardPt.get(1) - returnPt.get(1);
            if(diff >= 0){
                if(diff < closest){
                    rst.clear();
                    closest = diff;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(forwardPt.get(0));
                    temp.add(returnPt.get(0));
                    rst.add(temp);
                }
                else if(diff == closest){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(forwardPt.get(0));
                    temp.add(returnPt.get(0));
                    rst.add(temp);
                }
                pt1++;
            }
            else{
                pt2--;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int maximumOperatingTravelDistance = 10000;
//        Integer[][] forward_arr = {{1, 2000}, {2, 4000}, {3, 6000}};
        Integer[][] forward_arr = {{1, 3000}, {2, 5000}, {3, 7000}, {4, 10000}};
        List<List<Integer>> forwardShipping = new ArrayList<>();
        for(Integer[] arr: forward_arr){
            forwardShipping.add(Arrays.asList(arr));
        }
//        Integer[][] return_arr  = {{1, 2000}};
        Integer[][] return_arr  = {{1, 2000},{2, 3000},{3, 4000}, {4, 5000}};
        List<List<Integer>> returnShippingRouteList = new ArrayList<>();
        for(Integer[] arr: return_arr){
            returnShippingRouteList.add(Arrays.asList(arr));
        }
        List<List<Integer>> rst = flight(maximumOperatingTravelDistance, forwardShipping, returnShippingRouteList);
        System.out.println(rst);
    }
}
