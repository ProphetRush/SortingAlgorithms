package com.sortAlgorithms;

import com.sortAlgorithms.Algorithms.BubbleSort;
import com.sortAlgorithms.Algorithms.MergeSort;
import com.sortAlgorithms.Algorithms.QuickSort;
import com.sortAlgorithms.Utils.Utils;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	    int[] test = {3,6,4,9,8,7,5,2};
	    int[] test2 = {2,9,5,4,8,1,6,7};
        QuickSort.simpleQuickSort(test2);
        Utils.printArray(test2);
    }
}
