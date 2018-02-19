package com.sortAlgorithms.Utils;

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
}
