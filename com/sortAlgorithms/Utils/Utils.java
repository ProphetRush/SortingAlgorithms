package com.sortAlgorithms.Utils;

import java.util.Random;

public class Utils {
    public static void printArray(int[] list){
        if(list.length<100){
            for(int i=0; i<list.length; i++){
                System.out.println(list[i]+"  ");
            }
        }else{
            for(int i=0; i<100; i++){
                System.out.println(list[i]+"  ");
            }
        }
    }

    public static <E> void printArray(E[] list){
        if(list.length<100){
            for(int i=0; i<list.length; i++){
                System.out.println(list[i]+"  ");
            }
        }else{
            for(int i=0; i<100; i++){
                System.out.println(list[i]+"  ");
            }
        }
    }

    public static int[] randomIntArrayGenerator(int length){
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000000);
        }
        return array;
    }

    public static Integer[] randomIntegerArrayGenerator(int length){
        Integer[] array = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000000);
        }
        return array;
    }


    public static int[] duplicatedRandomIntArrayGenerator(int length, int width){
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i+=width) {
            int tmp = random.nextInt(100000000);
            for (int j = 0; j < width; j++) {
                array[i+j] = tmp;
            }
        }
        return array;
    }

}
