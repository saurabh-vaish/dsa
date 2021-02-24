package Problems;

import util.Stopwatch;

import java.util.HashMap;

public class FindNumberWithSumOfTwoNumbersFromTwoArrays {

    public static void main(String[] args) {
        int[] ar1 = new int[]{1,4,10,-2,0,7,3};
        int[] ar2 = new int[]{2,5,8,-3,7,1,0,10,9,-4};
        int targetNum = 15;

        System.out.println("Target Sum == "+targetNum);
        long s1 = Stopwatch.start();
        System.out.println("Result with pairs Non-Optimize sol. ="+ targetSumInTwoArrayNonOptimize(ar1,ar2,targetNum));
        long s2 = Stopwatch.end();
        Stopwatch.totalTime(s1,s2);

        long s3 = Stopwatch.start();
        System.out.println("Result with pairs Optimize sol. = "+ targetSumInTwoArrayDpp(ar1,ar2,targetNum));
        long s4 = Stopwatch.end();
        Stopwatch.totalTime(s3,s4);

    }

    private static String targetSumInTwoArrayDpp(int[] ar1, int[] ar2, int num) {
        String msg="false";
        int[] smallAr;  int[] bigAr;
        if(ar1.length>ar2.length){
            smallAr=ar2;
            bigAr=ar1;
        }else{
            smallAr=ar1;
            bigAr=ar2;
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int elem:smallAr) {
            if (!map.containsKey(num - elem)) {
                map.put(num-elem,elem);
            }
        }

        for (int elem : bigAr) {
            if (map.containsKey(elem)) {
                msg = true + " [" + map.get(elem) + "," + elem + "] ";
                break;
            }
        }
        return msg;
    }


    private static String targetSumInTwoArrayNonOptimize(int[] ar1, int[] ar2, int num) {
        String msg="false";
        boolean isFound=false;
        for (int elem1:ar1) {
            for (int elem2 : ar2) {
                if (elem1+elem2==num) {
                    msg = true + " [" + elem1 + "," + elem2 + "] ";
                    isFound = true;
                    break;
                }
            }
            if(isFound)break;
        }
        return msg;
    }

}
