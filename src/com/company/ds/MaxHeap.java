package com.company.ds;

import java.util.Arrays;
import java.util.Scanner;

public class MaxHeap {

    public static int[] array;
    public static int heapSize;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        array = new int[size];
        for(int i=0; i<size;i++){
            System.out.print("Enter "+(i+1)+"th element: ");
            array[i] = scanner.nextInt();
        }
        heapSize = size;
        buildMaxHeap();
        printMaxHeap();

        try {
            increaseKey(heapSize - 1,120);
            printMaxHeap();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            decreaseKey(0,1);
            printMaxHeap();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            insertKey(120);
            printMaxHeap();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        while (heapSize > -1) {
            try {
                System.out.println("Max is: " + extractMax());
                printMaxHeap();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public static void printMaxHeap(){
        System.out.print("Max heap is : ");
        for(int i= 0;i<heapSize;i++){
            if(i == heapSize - 1) {
                System.out.print(array[i]);
            }else {
                System.out.print(array[i]+",");
            }
        }
        System.out.println();
    }

    public static void buildMaxHeap(){
        for(int i = Math.floorDiv(heapSize,2) - 1;i >= 0; i--){
            maxHeapify(i);
        }
    }

    public static void maxHeapify(int index){
        int l = (2*index)+1;
        int r = 2*(index+1);
        int indexToLargest;
        if(l < heapSize && array[l] > array[index]){
            indexToLargest = l;
        }else{
            indexToLargest = index;
        }
        if(r < heapSize && array[r] > array[indexToLargest]){
            indexToLargest = r;
        }
        if(indexToLargest != index){
            exchange(index,indexToLargest);
            maxHeapify(indexToLargest);
        }
    }

    public static void exchange(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int extractMax() throws Exception {
        if (heapSize < 1){
            throw new Exception("HeapUnderFlowException");
        }
        int max = array[0];
        array[0] = array[heapSize - 1];
        heapSize --;
        maxHeapify(0);
        return max;
    }

    private static void increaseKey(int index, int key) throws Exception {
        if(array[index] >= key){
            throw new Exception("InvalidOperationException");
        }
        array[index] = key;
        while(index > 0 && array[index] > array[(index-1)/2]){
            exchange(index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }

    private static void decreaseKey(int index, int key) throws Exception {
        if(array[index] <= key){
            throw new Exception("InvalidOperationException");
        }
        array[index] = key;
        maxHeapify(index);
    }

    private static void insertKey(int key) throws Exception {
        array = Arrays.copyOf(array,++heapSize);
        array[heapSize - 1] = Integer.MIN_VALUE;
        increaseKey(heapSize -1,key);
    }
}
