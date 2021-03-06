package com.sortAlgorithms;

import com.sortAlgorithms.Algorithms.*;
import com.sortAlgorithms.Algorithms.MultiThreadSorting;
import com.sortAlgorithms.Utils.Timer;
import com.sortAlgorithms.Utils.Utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException, IOException {
//        int[] test = {3,6,4,9,8,7,5,2};

//        Timer.execute(InsertionSort.class.getMethod("insertionSort", int[].class), test);
//        test = tmp.clone();
//        Timer.execute(SelectionSort.class.  ("selectionSort", int[].class), test);
//        test = tmp.clone();
//        Timer.execute(BubbleSort.class.getMethod("bubbleSort", int[].class), test);
//        test = tmp.clone();

        int[] tmp = Utils.duplicatedRandomIntArrayGenerator(10000000, 100);
        int[] test = tmp.clone();


        Timer.execute(Arrays.class.getMethod("sort", int[].class), test);
        test = tmp.clone();
        Timer.execute(MergeSort.class.getMethod("mergeSort", int[].class), test);
        test = tmp.clone();
        Timer.execute(HeapSort.class.getMethod("heapSort", int[].class), test);
        test = tmp.clone();
        Timer.execute(QuickSort.class.getMethod("simpleQuickSort", int[].class), test);
        test = tmp.clone();
        Timer.execute(QuickSort.class.getMethod("optimizedQuickSort", int[].class), test);
        test = tmp.clone();
        Timer.execute(QuickSort.class.getMethod("optimizedQuickSortForDuplicate", int[].class), test);


        test = tmp.clone();
        Timer.execute(MultiThreadSorting.class.getMethod("sortWithMultiThreading", int[].class), test);


//        Timer.execute(Utils.class.getMethod("createLargeRandomData", long.class), new Object[]{10000000});
//
//        Timer.execute(ExternalSort.class.getMethod("externalSort", String.class, String.class), new Object[]{"../LargeRandomData.dat", "../sortedData.dat"});


    }
}
