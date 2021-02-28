package array;

import util.Stopwatch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] ar = new int[]{2,5,6,9,11,14,16,20};   // sorted array
        int searchElement = 16;

        System.out.print("Given Array == ");
        print(ar);

        long s1 = Stopwatch.start();
        int index = searchElementUsingBinarySearch(ar,searchElement);
        if(index<0){
            System.out.println("element not found !!");
        }else{
            System.out.println("Element found at index = "+index);
        }
        long s2 = Stopwatch.end();
        Stopwatch.totalTime(s1,s2);

    }

    private static int searchElementUsingBinarySearch(int[] arr, int searchElem) {
        int start=0; int end= arr.length-1;
        int mid;
        do {
            mid = (start+end)/2;
            if (searchElem == arr[mid]) return mid;
            else if (searchElem < arr[mid]) {
                end = mid - 1;              // go to left part of array
            } else  {
                start = mid+1;              // go to right part of array
            }
        } while (start <= end);
        return -1;
    }


    private static void print(int[] ar) {
        for (int i : ar) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}

