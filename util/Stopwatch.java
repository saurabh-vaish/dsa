package util;

import java.util.concurrent.TimeUnit;

public class Stopwatch {
    public static long start(){
        return System.currentTimeMillis();
    }
    public static long end(){
        return System.currentTimeMillis();
    }
    public static void totalTime(long start,long end){
        long timeInMs= end-start;
        if(timeInMs<=1000) {
            System.out.println(timeInMs+"ms");
        }
        else if(timeInMs<1000*60*60) {
            System.out.println(TimeUnit.MILLISECONDS.toSeconds(timeInMs)+"sec");
        }
    }
}
