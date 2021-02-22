package DSExample;

public class DeletionInArray {

    private int[] arr = {2,3,5,11,56,34,5};

    public static void main(String[] args) {

        DeletionInArray deletionInArray = new DeletionInArray();

        System.out.print("Array before deletion =  ");

        printArray(deletionInArray);

        deletionInArray.arr = deletionInArray.deletionAtBeginning(deletionInArray.arr);

        System.out.print("Array after deletion at beginning = ");

        printArray(deletionInArray);

        deletionInArray.arr = deletionInArray.deletionAtAnyPoint(deletionInArray.arr,3);

        System.out.print("Array after deletion at index 3 = ");

        printArray(deletionInArray);

    }

    private static void printArray(DeletionInArray deletionInArray) {
        for (int i = 0; i < deletionInArray.arr.length; i++) {
            System.out.print(deletionInArray.arr[i]+"  ");
        }
        System.out.println("    array  length  is  = "+deletionInArray.arr.length);
    }


    private int[] deletionAtBeginning(int[] arr){
        if(arr.length>0) {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                newArr[i] = arr[i + 1];
            }
            return newArr;
        }else{
            return arr;
        }
    }

    private int[] deletionAtAnyPoint(int[] arr, int index){
        if(index >= 0 && index < arr.length) {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                if(i<index)
                    newArr[i] = arr[i];
                else
                    newArr[i] = arr[i + 1];
            }
            return newArr;
        }else{
            return arr;
        }
    }

}
