package com.sortAlgorithms.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap<E extends Comparable<E>>{

    private ArrayList<E> list = new ArrayList<>();

    private int[] array;


    public Heap(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    public Heap(int[] arr){
        array = arr;
        buildMaxHeap();
    }

    public void add(E obj){
        list.add(obj);
        int index = list.size()-1;
        while(index>0){
            int parentIndex = (index-1)>>>1;
            if(list.get(index).compareTo(list.get(parentIndex))>0){
                E tmp = list.get(parentIndex);
                list.set(parentIndex, list.get(index));
                list.set(index, tmp);
            }else break;

            index = parentIndex;
        }
    }


    public E removeTop(){
        if(list.size() == 0) return null;

        E obj = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.remove(list.size()-1);
        int index = 0;
        while(index<list.size()){
            int leftChildIndex = 2*index+1;
            int rightChildIndex = 2*index+2;
            if(leftChildIndex >= list.size()) break;
            int maxIndex = leftChildIndex;
            if(rightChildIndex<list.size()){
                if(list.get(maxIndex).compareTo(list.get(rightChildIndex))<0){
                    maxIndex = rightChildIndex;
                }
            }

            if(list.get(index).compareTo(list.get(maxIndex))<0){
                E tmp = list.get(maxIndex);
                list.set(maxIndex, list.get(index));
                list.set(index, tmp);
                index = maxIndex;
            }else break;
        }
        return obj;
    }




    private void adjustDownToUp(int k,int length){
        int temp = array[k];
        for(int i=2*k+1; i<length-1; i=2*i+1){
            if(i<length && array[i]<array[i+1]){
                i++;
            }
            if(temp>=array[i]){
                break;
            }else{
                array[k] = array[i];
                k = i;
            }
        }
        array[k] = temp;
    }


    public void heapSort(){
        for(int i=array.length-1;i>1;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustDownToUp(0,i);
        }
    }


    private void buildMaxHeap(){
        for(int i=(array.length-2)/2;i>=0;i--){
            adjustDownToUp(i,array.length);
        }
    }

}
