package dpp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// problem in a given array and target sum , find the shortest combination of elements to get target sum with the help of array elements, otherwise null;

// we can use elements any number of time

// all inputs are non negative

// solution subtract elements of array from target sum one by one.
// if returns 0 then those elements sum is target sum .
// if negative then not possible


// without dpp the complexity is O(n^m *m) and space is O(m^2)  where n = array length , m = target sum

// but with dpp the complexity is O(n * m^2) and space is O(m^2) , because its reducing the recalculation time


public class BestSumArray {

    public static void main(String[] args) {

        System.out.println("Starting =="+ LocalDateTime.now());
        // without DPP;
//        System.out.println(getSumElementsWithoutDpp(7,new int[]{2,3,4,7}));
//        System.out.println(getSumElementsWithoutDpp(7,new int[]{2,4}));
//        System.out.println(getSumElementsWithoutDpp(8,new int[]{1,4,5}));
//        System.out.println(getSumElementsWithoutDpp(8,new int[]{2,3,5}));
//        System.out.println(getSumElementsWithoutDpp(20,new int[]{5,3,4,7}));
////        System.out.println(getSumElementsWithoutDpp(300,new int[]{7,17}));
////        System.out.println(getSumElementsWithoutDpp(500,new int[]{9,14})); // not able to solve within minute also
//        System.out.println("Ending =="+ LocalDateTime.now());  // total time taken 2sec ,400 ms without 20


        System.out.println("Starting =="+ LocalDateTime.now());
        // with the help of DPP
//        System.out.println(getSumElementsWithDpp(7,new int[]{2,3,4,7},new HashMap<>()));
//        System.out.println(getSumElementsWithDpp(7,new int[]{2,4}, new HashMap<>()));
        System.out.println(getSumElementsWithDpp(8,new int[]{1,4,5},new HashMap<>()));
//        System.out.println(getSumElementsWithDpp(8,new int[]{2,3,5}, new HashMap<>()));
//        System.out.println(getSumElementsWithDpp(20,new int[]{5,3,4,7}, new HashMap<>()));
//        System.out.println(getSumElementsWithDpp(300,new int[]{7,17}, new HashMap<>()));
//        System.out.println(getSumElementsWithDpp(500,new int[]{9,14}, new HashMap<>()));
//        System.out.println("ending =="+ LocalDateTime.now());  // total time taken 1ms or same

    }


    private static List<Integer> getSumElementsWithoutDpp(int targetSum, int [] arr) {
        if(targetSum==0)return new ArrayList<>();
        if(targetSum<0)return null;
        List<Integer> shortest = null;
        for (int element : arr) {
            int remainder = targetSum - element;
            List<Integer> result = getSumElementsWithoutDpp(remainder, arr);
            if (result != null) {
                result.add(element);
                if(shortest==null || result.size()<shortest.size()){
                    shortest = result;
                }
            }
        }
        return shortest;
    }

    // not working
    private static List<Integer> getSumElementsWithDpp(int targetSum, int [] arr,Map<Integer,List<Integer>> dppMemo) {
        if(dppMemo.containsKey(targetSum) && dppMemo.get(targetSum).size()!=0)return dppMemo.get(targetSum);
        if(targetSum==0)return new ArrayList<>();
        if(targetSum<0)return null;
        List<Integer> shortest = null;
        for (int element : arr) {
            int remainder = targetSum - element;
           final List<Integer> result = getSumElementsWithDpp(remainder, arr,dppMemo);
            if (result != null) {
                result.add(element);
                if(shortest==null || result.size()<shortest.size()){
                    shortest = result;
                }
            }
        }
        dppMemo.put(targetSum, shortest==null?new ArrayList<>():shortest);
        return shortest;
    }

}
