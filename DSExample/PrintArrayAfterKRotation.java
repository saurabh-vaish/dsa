package DSExample;

public class PrintArrayAfterKRotation {

    private int[] arr = {2,3,5,11,56,7,9,22};

    public static void main(String[] args) {

        PrintArrayAfterKRotation rotation = new PrintArrayAfterKRotation();

        System.out.print("Array before rotation =  ");

        printArray(rotation.arr);

        rotation.arr = rotation.rotateArray(rotation.arr,3);

        System.out.print("Array after rotating 3 times = ");

        printArray(rotation.arr);

    }

    private static void printArray(int []  arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }


    private int[] rotateArray(int[] arr,int k){
        if(arr.length>0) {
            int[] newArr = new int[arr.length +k];
            for (int i = 0; i <arr.length ; i++) {
                if(i<k)
                    newArr[arr.length+i] = arr[i];
                else
                    newArr[i] = arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i]=newArr[i+k];
            }
            return arr;
        }else{
            return arr;
        }
    }

}
