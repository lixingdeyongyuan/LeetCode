package utils;

public class TimeRecord {

    private static long sStartTime = 0;
    public static void start(){
        sStartTime = System.currentTimeMillis();
    }

    public static void end(){
        long costTime = System.currentTimeMillis() - sStartTime;
        System.out.println("耗时："+costTime);
    }

}
