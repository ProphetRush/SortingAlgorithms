package com.sortAlgorithms.Algorithms;

public class MergeSort {
    public static void mergeSort(int[] list, int start, int end){
            int mid = (start+end)>>>1;
            if(start<end){
                mergeSort(list, start, mid);
                mergeSort(list, mid+1, end);
                merge(list, start, mid, end);
            }
    }

    private static void merge(int[] list, int start, int mid, int end){
        int[] tmp = new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0; //temp Index
        while (i<=mid && j<=end){
            if(list[i]<=list[j]){
                tmp[k++] = list[i++];
            }else{
                tmp[k++] = list[j++];
            }
        }
        while (i<=mid){
            tmp[k++] = list[i++];
        }
        while (j<=end){
            tmp[k++] = list[j++];
        }
        for (int l = 0; l < tmp.length; l++) {
            list[start+l] = tmp[l];
        }
    }

    public static void mergeSort(int[] list){
        mergeSort(list, 0, list.length-1);
    }



//    //Only create one temp array.
//    public static void mergeSort(int[] list, int[] temp, int start, int end){
//        int mid = (start+end)>>>1;
//        if(start<end){
//            mergeSort(list, temp, start, mid);
//            mergeSort(list, temp, mid+1, end);
//            merge(list, temp, start, mid, end);
//        }
//    }
//
//    private static void merge(int[] list, int[] tmp, int start, int mid, int end){
//        int i=start;
//        int j=mid+1;
//        int k=start; //temp Index
//        while (i<=mid && j<=end){
//            if(list[i]<=list[j]){
//                tmp[k++] = list[i++];
//            }else{
//                tmp[k++] = list[j++];
//            }
//        }
//        while (i<=mid){
//            tmp[k++] = list[i++];
//        }
//        while (j<=end){
//            tmp[k++] = list[j++];
//        }
//        for (int l = start; l < tmp.length; l++) {
//            list[l] = tmp[l];
//        }
//    }
//
//    public static void mergeSort(int[] list){
//        int[] tmp = list.clone();
//        mergeSort(list, tmp, 0, list.length-1);
//    }
}
