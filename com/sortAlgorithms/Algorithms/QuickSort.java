package com.sortAlgorithms.Algorithms;



public class QuickSort {

    final static int MAX_LENGTH_INSERT_SORT = 7;

    public static void simpleQuickSort(int[] list){
        simpleQuickSort(list, 0, list.length-1);
    }

    public static void simpleQuickSort(int[] list, int start, int end){
        if(start<end){
            int pivotIndex = partition(list, start, end);      //After every partition, the pivot index divided the array into two parts.
            simpleQuickSort(list, start, pivotIndex-1);
            simpleQuickSort(list, pivotIndex+1, end);
        }
    }


    private static int partition(int[] list, int start, int end){
        //choosePivot(list, start, end);
        int pivot = list[start];
        int i = start+1;
        int j = end;
        while(i<j){
            while(i<=j && list[i]<=pivot) i++;     //Search forward to find an element greater than pivot.
            while(i<=j && list[j]>pivot) j--;      //Search backward to find an element less than pivot
            if(i<j){
                int tmp = list[j];
                list[j] = list[i];
                list[i] = tmp;
            }                                      //Swap them
        }

        while(j>start && list[j]>pivot) j--;       //To ensure list[j] is the last element less than pivot.

        if(pivot>list[j]){                         //Swap pivot and list[j] and return the new pivot index.
            list[start] = list[j];
            list[j] = pivot;
            return j;
        }else {
            return start;
        }
    }




    public static void optimizedQuickSort(int[] list, int start, int end){
        if(start<end){
            if(end-start>MAX_LENGTH_INSERT_SORT){                   //In small array insertion sort is more efficient
                int pivotIndex = optimizedPartition(list, start, end);      //After every partition, the pivot index divided the array into two parts.
                simpleQuickSort(list, start, pivotIndex-1);
                simpleQuickSort(list, pivotIndex+1, end);
            }else{
                InsertionSort.insertionSort(list, start, end);
            }

        }
    }

    public static void optimizedQuickSort(int[] list){
        optimizedQuickSort(list, 0, list.length-1);
    }





    //Optimize the unnecessary swapping
    private static int optimizedPartition(int[] list, int start, int end){
        choosePivot(list, start, end);
        int pivot = list[start];
        int i = start;
        int j = end;
        while(i<j){
            while(i<j && list[j]>=pivot){
                j--;
            }
            list[i] = list[j];
            while(i<j && list[i]<pivot) i++;
            list[j] = list[i];
        }
        list[i] = pivot;
        return i;
    }




    //median of three to get the pivot value
    private static void choosePivot(int[] list, int start, int end){
        int mid = (start+end)>>>1;
        if(list[start]>list[end]){
            int tmp = list[end];
            list[end] = list[start];
            list[start] = tmp;
        }
        if(list[mid]>list[end]){
            int tmp = list[end];
            list[end] = list[mid];
            list[mid] = tmp;
        }
        if(list[mid]>list[start]){
            int tmp = list[mid];
            list[mid] = list[start];
            list[start] = tmp;
        }

    }



    public static void optimizedQuickSortForDuplicate(int[] list){
        optimizedQuickSortForDuplicate(list, 0, list.length-1);
    }


    /*When an element is the same as pivot move it to the right side, and when a pass of partition is finished,
    * move it to around the pivot index, then in the next pass of quick sort you only need to sort the left and right except the duplicated part,
    * it can obviously reduce the iterate time in an array full of duplicatied elements.*/

    public static void optimizedQuickSortForDuplicate(int[] list, int start, int end){
            if(end-start>MAX_LENGTH_INSERT_SORT){                   //In small array insertion sort is more efficient
                choosePivot(list, start, end);
                int pivot = list[start];
                int i = start;
                int j = end;
                int right = end;
                int rightLen = 0;
                while(i<j){
                    while(i<j && list[j]>=pivot){
                        if(list[j] == pivot){
                            list[j] = list[right];
                            list[right] = pivot;
                            right--;
                            rightLen++;
                        }
                        j--;
                    }
                    list[i] = list[j];
                    while(i<j && list[i]<pivot){
                        if(list[j] == pivot){
                            list[j] = list[right];
                            list[right] = pivot;
                            right--;
                            rightLen++;
                        }
                        i++;
                    }
                    list[j] = list[i];
                }
                list[i] = pivot;
                while(right!=end){
                    list[right]=list[i+end-right];
                    list[i+end-right] = pivot;
                    right++;
                }
                optimizedQuickSortForDuplicate(list, start, i-1);
                optimizedQuickSortForDuplicate(list, i+rightLen+1, end);
            }else {
                InsertionSort.insertionSort(list, start, end);
            }
    }

}
