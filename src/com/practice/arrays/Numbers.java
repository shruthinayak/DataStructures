package com.practice.arrays;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {

    static int distributeCandy(int[] score) {
//		https://www.hackerrank.com/challenges/candies

        int[] candy = new int[score.length];
        int count = 1;
        candy[0] = 1;
        for (int i = 1; i < score.length; i++) {
            if (score[i] > score[i - 1])
                candy[i] = candy[i - 1] + 1;
            else if (score[i] <= score[i - 1])
                candy[i] = 1;
        }
        for (int i = score.length - 1; i > 0; i--) {
            if (score[i] < score[i - 1] && candy[i] >= candy[i - 1])
                candy[i - 1] = candy[i] + 1;
        }
        int sum = 0;
        for (int i = 0; i < candy.length; i++)
            sum += candy[i];
        return sum;
    }

    enum Color {
        Red("Red", 255, 0, 0),
        Green("Green", 0, 255, 0),
        Blue("Blue", 0, 0, 255),
        Black("Black", 0, 0, 0),
        White("White", 255, 255, 255);

        String color;
        int r;
        int g;
        int b;

        Color(String color, int r, int g, int b) {
            this.color = color;
            this.r = r;
            this.g = g;
            this.b = b;
        }

    }

    public static void main(String[] args) {
        String[] s = {"0000000011111111111111111"};
        ClosestColor(s);
    }
    static String[] ClosestColor(String[] hexcodes) {
        String[] output = new String[hexcodes.length];
        int count=0;
        for(String hexCode: hexcodes){
            int r = Integer.parseInt(hexCode.substring(0, 8), 2);
            int g = Integer.parseInt(hexCode.substring(8, 16), 2);
            int b = Integer.parseInt(hexCode.substring(16, 24), 2);
            int[] array = {r,g,b};
            output[count++] = euclidean(array);
        }
        System.out.println(isMatches("000.255.244.54"));
        return output;
    }

    static String euclidean(int[] color) {
        HashMap<Integer, Integer> list = new HashMap<>();
        Color[] values = Color.values();
        double min = Integer.MAX_VALUE;
        Color fi = null;
        for (Color arr : values) {
            double sum = 0;
            sum += Math.pow((color[0] - arr.r), 2);
            sum += Math.pow((color[1] - arr.g), 2);
            sum += Math.pow((color[2] - arr.b), 2);
            sum = Math.sqrt(sum);
            if(!list.containsKey((int)sum)){
                list.put((int)sum, 0);
            }
            list.put((int)sum, list.get((int)sum)+1);

            if (sum < min) {
                fi = arr;
                min = sum;
            }
        }

        if(list.get((int)min)>1)
            return "Ambiguous";
        return fi.color;
    }

    static boolean isMatches(String ip){
        String IPADDRESS_PATTERN =
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
