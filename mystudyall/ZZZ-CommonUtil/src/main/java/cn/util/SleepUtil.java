package cn.util;

public class SleepUtil {
    public static void sleepMS(int ms){
        try {
            Thread.sleep(ms);
        }catch (InterruptedException e){
            System.out.println("cn.util.SleepUtil.sleeMS()......");
            e.printStackTrace();
        }
    }
    public static void sleepS(int s){
        try {
            Thread.sleep(s*1000);
        }catch (InterruptedException e){
            System.out.println("cn.util.SleepUtil.sleepS()......");
            e.printStackTrace();
        }
    }
}
