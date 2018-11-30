package com.company;
import java.util.Date;
public class Log {
    public static void to_console (String str){
        Date date = new Date();
        System.out.println(date.toString() + " " + str);
    }
}
