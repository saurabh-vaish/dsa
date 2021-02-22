package Problems;


// problem -- find the max area of water in a array of elements by considering array elements as walls of tank in x-asix
// constraints -- 1. array can be empty or single element
// 2. we cant use boundaries of x-axis
// 3. All positive and non duplicate numbers

// solution - compare elements of array with another take min as length , for width consider the distance b/w them
// e.g. min(ar[i],ar[j]) * j-i ; 


public class GetMaxWaterContainer {

    public static void main(String[] args) {

        GetMaxWaterContainer ob = new GetMaxWaterContainer();
        int [] nums = {1,7,3,9,2,5,6,8,4,1};
        int [] nums1 = {7,1,2,3,9};

        System.out.println("non optimize solution start =====");
        System.out.println(System.currentTimeMillis());
        System.out.println(ob.nonOptimizeTwoPointerSolution(nums));
        System.out.println(ob.nonOptimizeTwoPointerSolution(nums1));

        // constraints cases
//        System.out.println(ob.nonOptimizeTwoPointerSolution(new int[]{}));
//        System.out.println(ob.nonOptimizeTwoPointerSolution(new int[]{4}));
//        System.out.println(ob.nonOptimizeTwoPointerSolution(new int[]{4,5}));
//        System.out.println(ob.nonOptimizeTwoPointerSolution(new int[]{9,2}));

        System.out.println("non optimize solution end=====");
        System.out.println(System.currentTimeMillis());


        System.out.println("optimize solution start=====");
        System.out.println(System.currentTimeMillis());

        // optimize solutions
        System.out.println(ob.optimizeSolution(nums));
//        System.out.println(ob.optimizeSolution(nums1));

//        // constraints cases
//        System.out.println(ob.optimizeSolutionWithMemonize(new int[]{}, 11));
//        System.out.println(ob.optimizeSolutionWithMemonize(new int[]{4}, 11));
//        System.out.println(ob.optimizeSolutionWithMemonize(new int[]{4,5}, 11));
//        System.out.println(ob.optimizeSolutionWithMemonize(new int[]{9,2}, 11));

        System.out.println("optimize solution end=====");
        System.out.println(System.currentTimeMillis());
    }

    private int nonOptimizeTwoPointerSolution(int[] nums) {
        int area = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                int min = Math.min(nums[i], nums[j]);
                if((min*(j-i))>area){
                    area = (min*(j-i));
                }
            }
        }
        return area;
    }

    private int optimizeSolution(int[] nums) { //{1,7,3,9,2,5,6,8,4,1}
        int area = 0,p1=0,p2=nums.length-1;
        while (p1<p2) {
            if(nums[p1]<=nums[p2]){
                int min = nums[p1];
                area = Math.max(area, min*(p2-p1));
                p1++;
            }else {
                int min = nums[p2];
                area = Math.max(area, min*(p2-p1));
                p2--;
            }
            System.out.println(area+" "+p1+" "+p2);
        }
        return area;
    }
}
