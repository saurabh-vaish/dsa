package dpp;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// problem in a given 2d grid find in how many ways we can reach to last element using bottom - right approach
// i.e either we can go bottom or in right


// solution if any in row or col is 0 then grid is hidden return 0;
// if row and col is 1 then only on step that is start and end is same  return 1;

// then either go bottom or right we will reduce row and col 1 step .


// without dpp the complexity is O(pow(2,m + n)) and space is O(m+n)

// but with dpp the complexity is O(m * n) and space is O(m + n) , because its reducing the recalculation time


public class GridGenerator {

    public static void main(String[] args) {

//        System.out.println("Starting =="+ LocalDateTime.now());
//        // without DPP;
//        System.out.println(gridCounterWithoutDpp(1,1));
//        System.out.println(gridCounterWithoutDpp(2,5));
//        System.out.println(gridCounterWithoutDpp(8,8));
//        System.out.println(gridCounterWithoutDpp(10,14));
//        System.out.println(gridCounterWithoutDpp(16,16));
//        System.out.println(gridCounterWithoutDpp(20,20)); // not able to calculate within minute also
//        System.out.println("Ending =="+ LocalDateTime.now());  // total time taken 2sec ,400 ms without 20


        System.out.println("Starting =="+ LocalDateTime.now());
        // with the help of DPP
        System.out.println(gridCounterWithDpp(1,1,new HashMap<>()));
        System.out.println(gridCounterWithDpp(2,5,new HashMap<>()));
        System.out.println(gridCounterWithDpp(8,8,new HashMap<>()));
        System.out.println(gridCounterWithDpp(10,14,new HashMap<>()));
        System.out.println(gridCounterWithDpp(16,16,new HashMap<>()));
        System.out.println(gridCounterWithDpp(20,20,new HashMap<>()));
        System.out.println("ending =="+ LocalDateTime.now());  // total time taken 3-4ms

    }


    private static int gridCounterWithoutDpp(int row,int col) {
        if(row<=0 || col <=0)return 0;
        if(row==1 && col ==1)return 1;
        return gridCounterWithoutDpp(row-1,col) + gridCounterWithoutDpp(row,col-1);
    }

    private static int gridCounterWithDpp(int row,int col, Map<String,Integer> dppMemo) {
        String key = row+","+col;
        if(dppMemo.containsKey(key))return dppMemo.get(key);
        if(row<=0 || col <=0)return 0;
        if(row==1 && col ==1)return 1;
        int rs= gridCounterWithDpp(row-1,col,dppMemo) + gridCounterWithDpp(row,col-1,dppMemo);
        dppMemo.put(key,rs);
        return rs;
    }
}
