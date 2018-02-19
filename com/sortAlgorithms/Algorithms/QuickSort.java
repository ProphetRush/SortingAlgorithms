package com.sortAlgorithms.Algorithms;

public class QuickSort {
    public static void simpleQuickSort(int[] list, int start, int end){
        if(start<end){
            int pivotIndex = partition(list, start, end);
            simpleQuickSort(list, start, pivotIndex-1);
            simpleQuickSort(list, pivotIndex+1, end);
        }
    }

    private static int partition(int[] list, int start, int end){
        int pivot = list[start];
        int i=start+1;
        int j=end;
        while(i<j){
            while(i<=j && list[i]<=pivot) i++;
            while (i<=j && list[j]>pivot) j--;
            if(i<j){
                int tmp=list[j];
                list[j] = list[i];
                list[i] = tmp;
            }
        }

        while(j>i && list[j]>=pivot) j--;

        if(pivot>list[j]){
            list[start] = list[j];
            list[j] = pivot;
            return j;
        }else return start;
    }

    public static void simpleQuickSort(int[] list){
        simpleQuickSort(list, 0, list.length-1);
    }
}
