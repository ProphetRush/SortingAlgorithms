package com.sortAlgorithms.Algorithms;

public class InsertionSort {
    public static void insertionSort(int[] list, int start, int end){
        if(list.length>0 && start>=0 && end<list.length){
            for (int i = start; i <= end ; i++) {
                int currentElement = list[i];
                int index;
                for (index = i-1; index>=0 && list[index]>currentElement; index--){
                    list[index+1] = list[index];
                }
                list[index+1] = currentElement;
            }
        }
    }

    public static void insertionSort(int[] list){
        insertionSort(list, 0, list.length-1);
    }
}
