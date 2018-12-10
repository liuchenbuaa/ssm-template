package com.zhuo.framework.utils;

/**
 * @author liuchen <liuchen03@kuaishou.com>
 * Created on 2018-12-09
 */
public class Secure {
    public static void main(String[] args) {

        double rate = 0.03;
        int money = 20000;

        System.out.println(Math.pow(1 + rate, 30));


        int result = 0;
        for (int i = 0;i < 5;i++) {
            double x = money/Math.pow(1 + rate, i);
            System.out.println(x);
            result += x;
        }





        int money1 = 300000;

        for (int i = 60; i <= 80;i++) {
            int now = 28;
            double x = money/Math.pow(1 + rate, i);
            System.out.println(x);
            result += x;
        }

        System.out.println(result);
    }
}
