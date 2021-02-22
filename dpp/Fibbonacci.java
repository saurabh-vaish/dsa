package dpp;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


// without dpp the complexity is O(pow(2,n)) and space is O(n)

// but with dpp the complexity is O(n) and space is O(n) , because its reducing the recalculation time



public class Fibbonacci {

    public static void main(String[] args) {

//        System.out.println("Starting =="+ LocalDateTime.now());
//        // without DPP;
//        System.out.println(fibWithoutDpp(5));
//        System.out.println(fibWithoutDpp(10));
//        System.out.println(fibWithoutDpp(30));
//        System.out.println(fibWithoutDpp(40));
//        System.out.println(fibWithoutDpp(50)); // not able to calculate within minute also
//        System.out.println("Ending =="+ LocalDateTime.now());  // total time taken 450 ms without 50


        System.out.println("Starting =="+ LocalDateTime.now());
        // with the help of DPP
        System.out.println(fibWithDpp(5,new HashMap<>()));
        System.out.println(fibWithDpp(10,new HashMap<>()));
        System.out.println(fibWithDpp(30,new HashMap<>()));
        System.out.println(fibWithDpp(40,new HashMap<>()));
        System.out.println(fibWithDpp(50,new HashMap<>()));
        System.out.println("ending =="+ LocalDateTime.now());  // total time taken 2ms with 50 , 1ms without 50

    }


    private static int fibWithoutDpp(int n) {
        if(n<=2)return 1;
        return fibWithoutDpp(n-1) + fibWithoutDpp(n-2);
    }

    private static Long fibWithDpp(int n, Map<Integer,Long> dppMemo) {
        if(dppMemo.containsKey(n))return dppMemo.get(n);
        if(n<=2)return 1L;
        Long rs= fibWithDpp(n-1,dppMemo) + fibWithDpp(n-2,dppMemo);
        dppMemo.put(n,rs);
        return rs;
    }
}
