/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WestminsterCarParkSystem;

import java.text.SimpleDateFormat;

/**
 *
 * @author lakshanG
 */
public class DateTime {

    public static long getCurrentTime() {
        long milTime = System.currentTimeMillis();
        return milTime;

    }

    public static String[] displayTime() {
        String[] time = new String[2];
        long milTime = getCurrentTime();
        SimpleDateFormat sddate = new SimpleDateFormat("ddMMyyyy");
        String currentDate = sddate.format(milTime);
        time[0] = currentDate;
        SimpleDateFormat sdtime = new SimpleDateFormat("HH:mm");
        String currentTime = sdtime.format(milTime);
        time[1] = currentTime;

        //System.out.println(currentDate);
        // System.out.println(currentTime);
        return time;
    }

    public static int[] calTime(long entryTime, long exitTime) {

        int timeArr[] = new int[2];

        long duration = exitTime - entryTime;

        int calSec = (int) (duration / 1000 % 60);
        int calMin = (int) (duration / (1000 * 60) % 60);
        timeArr[0] = calMin;
        int calHr = (int) (duration / (1000 * 60 * 60) % 60);
        timeArr[1] = calHr;
        int calDay = (int) (duration / (1000 * 60 * 60 * 24) % 24);
        int calYear = (int) (duration / (1000 * 60 * 60 * 24 * 365) % 365);
        System.out.println(calDay + ":" + calYear + ":" + calHr + ":" + calMin + ":" + calSec);
        return timeArr;
    }
//    public static void main(String[] args) {
//        long entryTime = getCurrentTime();
//        displayTime();
//        long exitTime = getCurrentTime();
//        displayTime();
//        calTime(entryTime, exitTime);
//    }

}
