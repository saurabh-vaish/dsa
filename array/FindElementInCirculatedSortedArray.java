package array;

import DSExample.PrintArrayAfterKRotation;
import util.Stopwatch;

public class FindElementInCirculatedSortedArray {

    public static void main(String[] args) {
        int[] sAr = new int[]{2,5,6,9,11,14,16,20};   // sorted array
//        int[] sAr=IntStream.rangeClosed(0, 20000).toArray();

        System.out.print("Given Array == ");
        print(sAr);

        int [] aAr = PrintArrayAfterKRotation.getRotatedArray(sAr,2);
        int searchElement=5;

        System.out.print("Array After Two Rotation = ");
        print(aAr);

        // using normal loop
        System.out.print("Using Loop == ");
        long s1 = Stopwatch.start();
        System.out.println(searchElementUsingLoop(aAr,searchElement));
        long s2 = Stopwatch.end();
        Stopwatch.totalTime(s1,s2);

        // using recursion
        System.out.print("Using Recursion == ");
        long s3 = Stopwatch.start();
        System.out.println(searchElementUsingRecursion(aAr,searchElement,0));  // don't use if array size is too big will cause stackoverflow
        long s4 = Stopwatch.end();
        Stopwatch.totalTime(s3,s4);

        // using recursion
        System.out.print("Using modified binary search == ");
        long s5 = Stopwatch.start();
        System.out.println(searchElementUsingModifiedBinarySearch(aAr,searchElement));
        long s6 = Stopwatch.end();
        Stopwatch.totalTime(s5,s6);

    }

    private static boolean searchElementUsingModifiedBinarySearch(int[] rsar,int searchElem) {
        int start=0; int end= rsar.length-1;
        int mid;
        do {
            mid = (start+end)/2;
            if (searchElem == rsar[mid]) return true;
            else if (rsar[mid] >= rsar[end]) {             // right part from middle
                if (searchElem < rsar[mid] && searchElem>=rsar[start]) {  // go to left part of array
                    end = mid - 1;
                } else  {
                    start = mid+1;
                }
            }else {             // left part from middle
                if (searchElem > rsar[mid]) {    // go to right part of array
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        } while (start <= end);
        return false;
    }

    private static boolean searchElementUsingLoop(int[] ar,int searchElement) {
        for (int j : ar) {
            if (j == searchElement) {
                return true;
            }
        }
        return false;
    }

    private static boolean searchElementUsingRecursion(int[] ar,int searchElement,int index) {
        if(index==ar.length)return false;
        if(ar[index]==searchElement)return true;
        return searchElementUsingRecursion(ar,searchElement,index+1);
    }

    private static void print(int[] ar) {
        for (int i : ar) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
