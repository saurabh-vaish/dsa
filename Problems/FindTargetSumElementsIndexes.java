package Problems;


// problem -- find the index of elements whose sum is equal to target sum .
// constraints -- 1. array can be empty or single element
// 2. No guaranty there will be always solution , if not return null
// 3. All positive and non duplicate numbers
// 4. max only one solution is available


import java.util.Arrays;
import java.util.HashMap;

public class FindTargetSumElementsIndexes {

    public static void main(String[] args) {

        FindTargetSumElementsIndexes ob = new FindTargetSumElementsIndexes();
        int [] nums = {1,3,7,9,2,5,6};

        System.out.println("non optimize solution start =====");
        System.out.println(System.currentTimeMillis());
        System.out.println(Arrays.toString(ob.nonOptimizeTwoPointerSolution(nums, 11)));

        // constraints cases
        System.out.println(Arrays.toString(ob.nonOptimizeTwoPointerSolution(new int[]{}, 11)));
        System.out.println(Arrays.toString(ob.nonOptimizeTwoPointerSolution(new int[]{4}, 11)));
        System.out.println(Arrays.toString(ob.nonOptimizeTwoPointerSolution(new int[]{4,5}, 11)));
        System.out.println(Arrays.toString(ob.nonOptimizeTwoPointerSolution(new int[]{9,2}, 11)));

        System.out.println("non optimize solution end=====");
        System.out.println(System.currentTimeMillis());


        System.out.println("optimize solution start=====");
        System.out.println(System.currentTimeMillis());

        // optimize solutions
        System.out.println(Arrays.toString(ob.optimizeSolutionWithMemonize(nums, 11)));

        // constraints cases
        System.out.println(Arrays.toString(ob.optimizeSolutionWithMemonize(new int[]{}, 11)));
        System.out.println(Arrays.toString(ob.optimizeSolutionWithMemonize(new int[]{4}, 11)));
        System.out.println(Arrays.toString(ob.optimizeSolutionWithMemonize(new int[]{4,5}, 11)));
        System.out.println(Arrays.toString(ob.optimizeSolutionWithMemonize(new int[]{9,2}, 11)));

        System.out.println("optimize solution end=====");
        System.out.println(System.currentTimeMillis());
    }

    private int[] nonOptimizeTwoPointerSolution(int[] nums, int target) {

//        if(nums.length==0 || nums.length==1)return new int[0];
//        else if(nums.length==2 && nums[0]+nums[1]!=target) return new int[0];

        for (int i = 0; i < nums.length; i++) {
            int tnum = target-nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                if(nums[j]==tnum){
                   return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    private int[] optimizeSolutionWithMemonize(int[] nums, int target) {

//        if(nums.length==0 || nums.length==1)return new int[0];
//        else if(nums.length==2 && nums[0]+nums[1]!=target) return new int[0];

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
