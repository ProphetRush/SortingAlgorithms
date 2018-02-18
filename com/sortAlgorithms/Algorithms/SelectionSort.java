package com.sortAlgorithms.Algorithms;

public class SelectionSort {
    public static void selectionSort(int[] list, int start, int end){
        int currentMin;
        int currentMinIndex;
        if(list.length>0 && start>=0 && end<list.length){
            for (int i = start; i < end; i++) {
                currentMin = list[i];
                currentMinIndex = i;
                for (int j = i+1; j <= end; j++) {
                    if(list[j] < currentMin){
                        currentMin = list[j];
                        currentMinIndex = j;
                    }
                }
                if(currentMinIndex!=i){
                    list[currentMinIndex] = list[i];
                    list[i] = currentMin;
                }
            }
        }
    }

    public static void selectionSort(int[] list){
        selectionSort(list, 0, list.length-1);
    }
}
