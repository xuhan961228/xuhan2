package util;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static java.util.UUID.*;

public class Uuid {


    public static String getString() {
        return UUID.randomUUID().toString().replaceAll("-", "");

    }
    public static int getRandom(){
        int num = (int)(Math.random() * (1000000000 - 10 + 1) + 10);
        return num;
    }
    public static String getRandomString(){
        String str="1234567890abcdefghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();

        StringBuffer sb=new StringBuffer();

        for(int i=0;i<10;i++){

            int number =random.nextInt(10);

            sb.append(str.charAt(number));
        }
        return sb.toString();
    }



}
