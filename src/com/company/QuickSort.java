package com.company;

import java.util.Scanner;

public class QuickSort {

    private static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        array = new int[size];
        for(int i=0; i<size;i++){
            System.out.print("Enter "+(i+1)+"th element: ");
            array[i] = scanner.nextInt();
        }
        quickSort(0,size-1);
        System.out.print("Sorted elements are: ");
        for(int i= 0;i<array.length;i++){
            if(i == array.length - 1) {
                System.out.print(array[i]);
            }else {
                System.out.print(array[i]+",");
            }
        }
    }

    private static void quickSort(int beginingIndex, int endingIndex){
        if(beginingIndex<endingIndex){
            int partitionIndex = partition(beginingIndex,endingIndex);
            quickSort(beginingIndex,partitionIndex - 1);
            quickSort(partitionIndex+1,endingIndex);
        }
    }

    private static int partition(int beginingIndex, int endingIndex){
        int pivot = array[endingIndex];
        int i = beginingIndex - 1;
        for(int j=beginingIndex; j<endingIndex;j++){
            if(array[j]<=pivot){
                i++;
                exchange(i,j);
            }
        }
        exchange(i+1,endingIndex);
        return i+1;
    }

    private static void exchange(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
