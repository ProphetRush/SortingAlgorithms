package com.sortAlgorithms.Algorithms;

import com.sortAlgorithms.Utils.Heap;
import com.sortAlgorithms.Utils.Timer;

public class HeapSort {

    public static <E extends Comparable<E>> void heapSort(E[] list){
        Heap<E> heap = new Heap<>(list);
        for (int i = list.length-1; i>=0; i--) {
            list[i] = heap.removeTop();
        }
    }

    public static <E extends Comparable<E>> void heapSort(int[] list){
        Heap<E> heap = new Heap<>(list);
        heap.heapSort();
    }
}
