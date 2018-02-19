package com.sortAlgorithms;

import com.sortAlgorithms.Algorithms.BubbleSort;
import com.sortAlgorithms.Algorithms.HeapSort;
import com.sortAlgorithms.Algorithms.MergeSort;
import com.sortAlgorithms.Algorithms.QuickSort;
import com.sortAlgorithms.Utils.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    Integer[] test = {3,6,4,9,8,7,5,2};
	    int[] test2 = {4,9,5,4,2,4,8,1,6};
        HeapSort.heapSort(test2);
        Utils.printArray(test2);
    }
}
