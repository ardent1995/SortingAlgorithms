package com.company;

import com.company.ds.MaxHeap;

import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size;i++){
            System.out.print("Enter "+(i+1)+"th element: ");
            array[i] = scanner.nextInt();
        }
        int[] sortedArray = heapSort(array);
        System.out.print("Sorted elements are: ");
        for(int i= 0;i<sortedArray.length;i++){
            if(i == sortedArray.length - 1) {
                System.out.print(sortedArray[i]);
            }else {
                System.out.print(sortedArray[i]+",");
            }
        }
    }

    private static int[] heapSort(int[] array){
        MaxHeap.array = array;
        MaxHeap.heapSize = array.length;
        MaxHeap.buildMaxHeap();
        for(int i = array.length - 1; i>= 1; i--){
            MaxHeap.exchange(i,0);
            MaxHeap.heapSize --;
            MaxHeap.maxHeapify(0);
        }
        return MaxHeap.array;
    }
}
