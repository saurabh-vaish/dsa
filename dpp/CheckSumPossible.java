package dpp;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// problem in a given array and target sum , find if it is possible to find target sum with the help of array elements

// we can use elements any number of time

// all inputs are non negative

// solution subtract elements of array from target sum one by one.
// if returns 0 then those elements sum is target sum .
// if negative then not possible


// without dpp the complexity is O(pow(n,m)) and space is O(m)  where n = array length , m = target sum

// but with dpp the complexity is O(m * n) and space is O(m) , because its reducing the recalculation time


public class CheckSumPossible {

    public static void main(String[] args) {

        System.out.println("Starting =="+ LocalDateTime.now());
        // without DPP;
        System.out.println(checkSumWithoutDpp(7,new int[]{2,3,4,7}));
        System.out.println(checkSumWithoutDpp(7,new int[]{2,4}));
        System.out.println(checkSumWithoutDpp(7,new int[]{2,3}));
        System.out.println(checkSumWithoutDpp(20,new int[]{5,3,4,7}));
        System.out.println(checkSumWithoutDpp(300,new int[]{7,17}));
        System.out.println(checkSumWithoutDpp(500,new int[]{7,14})); // not
        System.out.println(checkSumWithoutDpp(1500,new int[]{7,17,20})); // not able to solve within minute also
        System.out.println("Ending =="+ LocalDateTime.now());  // total time taken 2sec ,400 ms without 20


        System.out.println("Starting =="+ LocalDateTime.now());
        // with the help of DPP
        System.out.println(checkSumWithDpp(7,new int[]{2,3,4,7},new HashMap<>()));
        System.out.println(checkSumWithDpp(7,new int[]{2,4},new HashMap<>()));
        System.out.println(checkSumWithDpp(7,new int[]{2,3},new HashMap<>()));
        System.out.println(checkSumWithDpp(20,new int[]{5,3,4,7},new HashMap<>()));
        System.out.println(checkSumWithDpp(300,new int[]{7,17},new HashMap<>()));
        System.out.println(checkSumWithDpp(500,new int[]{7,14},new HashMap<>()));
        System.out.println(checkSumWithDpp(1500,new int[]{7,17,20},new HashMap<>()));
        System.out.println("ending =="+ LocalDateTime.now());  // total time taken 1ms or same

    }


    private static boolean checkSumWithoutDpp(int targetSum, int [] arr) {
        if(targetSum==0)return true;
        if(targetSum<0)return false;
        for (int i = 0; i < arr.length; i++) {
            int remainder = targetSum - arr[i];
            if(checkSumWithoutDpp(remainder,arr)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkSumWithDpp(int targetSum, int [] arr, Map<Integer,Boolean> dppMemo) {
        if(dppMemo.get(targetSum)!=null)return dppMemo.get(targetSum);
        if(targetSum==0)return true;
        if(targetSum<0)return false;
        for (int i = 0; i < arr.length; i++) {
            int remainder = targetSum - arr[i];
            dppMemo.put(targetSum, true);
            if(checkSumWithDpp(remainder,arr,dppMemo)){
                return true;
            }
        }

        dppMemo.put(targetSum, false);
        return false;
    }

}
