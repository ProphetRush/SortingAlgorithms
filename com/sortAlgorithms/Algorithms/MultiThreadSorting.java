package com.sortAlgorithms.Algorithms;

import com.sortAlgorithms.Algorithms.InsertionSort;
import com.sortAlgorithms.Algorithms.MergeSort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MultiThreadSorting{
    public static void sortWithMultiThreading(int[] list, int start, int end){
        (new ForkJoinPool()).invoke(new MTMergeSort(list, start, end));
    }

    public static void sortWithMultiThreading(int[] list){
        (new ForkJoinPool()).invoke(new MTMergeSort(list, 0, list.length-1));
    }


    private static class MTMergeSort extends RecursiveAction {
        private static final int INSERTION_SORT_THRESHOLD = 7;
        private int[] list;
        private int start;
        private int end;

        public MTMergeSort(int[] list, int start, int end){
            this.list = list;
            this.start = start;
            this.end = end;
        }

        public MTMergeSort(int[] list){
            this.list = list;
            this.start = 0;
            this.end = list.length-1;
        }

        @Override
        protected void compute() {
            if(end-start<=INSERTION_SORT_THRESHOLD){
                InsertionSort.insertionSort(list, start, end);
            }else {
                int[] left = Arrays.copyOfRange(list, start, (end-start+1) / 2);
                int[] right = Arrays.copyOfRange(list, (end-start+1) / 2, list.length);
                invokeAll(new MTMergeSort(left), new MTMergeSort(right));
                merge(left, right, list);
            }
        }

        private void merge(int[] left, int[] right, int[] list) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    list[k] = left[i];
                    i++;
                } else {
                    list[k] = right[j];
                    j++;
                }
                k++;
            }
            if (i == left.length) {
                for (; j < right.length; j++, k++) {
                    list[k] = right[j];
                }
            } else {
                for (; i < left.length; i++, k++) {
                    list[k] = left[i];
                }
            }
        }
    }

}

