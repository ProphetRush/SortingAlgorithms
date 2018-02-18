package com.sortAlgorithms.Algorithms;

public class BubbleSort {
    public static void bubbleSort(int[] list, int start, int end){
        if(list.length>0 && start>=0 && end<list.length){
            boolean isSwapped = true;                           //After the first pass, the last element of the array is the biggest.
            for (int i = start; i <= end && isSwapped; i++) {   //if no swapping happened in last pass, the array is sorted, no need to do next pass.
                isSwapped = false;
                for (int j = start+1; j <= end-i; j++) {
                    if(list[j]<list[j-1]){
                        int temp = list[j];
                        list[j] = list[j-1];
                        list[j-1] = temp;
                        isSwapped = true;
                    }
                }
            }
        }
    }

    public static void bubbleSort(int[] list){
        bubbleSort(list, 0, list.length-1);
    }
}
