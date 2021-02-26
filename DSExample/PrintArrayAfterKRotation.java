package DSExample;

import util.Stopwatch;

public class PrintArrayAfterKRotation {

    private static int[] arr = {2,3,5,11,56,7,9,22};

    public static void main(String[] args) {

        System.out.print("Array before rotation =  ");
        printArray(arr);

        long s1 = Stopwatch.start();
        rotateArray(arr,3);
        long s2 = Stopwatch.end();

        System.out.print("Array after rotating 3 times = ");
        printArray(arr);

        Stopwatch.totalTime(s1,s2);
    }

    private static void printArray(int []  arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }


    private static int[] rotateArray(int[] arr,int k){
        if(arr.length>0) {
            int[] newArr = new int[arr.length +k];   // create new array with size of array + no of rotation
            for (int i = 0; i <arr.length ; i++) {
                if(i<k)                                // while index is less than rotation insert starting array to end of new array
                    newArr[arr.length+i] = arr[i];
                else
                    newArr[i] = arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i]=newArr[i+k];                 // copy again to reduce space before rotation index
            }
        }
        return arr;
    }


    public static int[] getRotatedArray(int []arr,int rotation){
        return rotateArray(arr,rotation);
    }

}
