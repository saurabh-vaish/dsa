package array;

import util.Stopwatch;

public class ArrayReverse {

    public static void main(String[] args) {
        int[] ar = new int[]{2,33,5,16,7,4,6,11,45};

        // using normal loop
        long s1 = Stopwatch.start();
        reverseUsingLoop(ar);
        long s2 = Stopwatch.end();
        print(ar);
        Stopwatch.totalTime(s1,s2);

        // using recursion
        long s3 = Stopwatch.start();
        reverseUsingRecursion(ar,0,ar.length-1);
        long s4 = Stopwatch.end();
        print(ar);
        Stopwatch.totalTime(s3,s4);

    }

    private static void reverseUsingRecursion(int[] ar,int start,int end) {
        if(start>=end)return;
        int temp=ar[start];
        ar[start]=ar[end];
        ar[end]=temp;
        reverseUsingRecursion(ar,start+1,end-1);
    }

    private static void reverseUsingLoop(int[] ar) {
        int start=0,end=ar.length-1;
        while (start<end){
            int temp=ar[start];
            ar[start]=ar[end];
            ar[end]=temp;
            start++;
            end--;
        }
    }

    private static void print(int[] ar) {
        for (int i : ar) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
