package com.company;

import java.util.Scanner;

public class MergeSort {

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
        mergeSort(0,size-1);
        System.out.print("Sorted elements are: ");
        for(int i= 0;i<array.length;i++){
            if(i == array.length - 1) {
                System.out.print(array[i]);
            }else {
                System.out.print(array[i]+",");
            }
        }
    }

    private static void mergeSort(int startingIndex, int endingIndex){
        if(endingIndex>startingIndex){
            int midIndex = (startingIndex+endingIndex)/2;
            mergeSort(startingIndex,midIndex);
            mergeSort(midIndex+1,endingIndex);
            merge(startingIndex,midIndex,endingIndex);
        }
    }

    private static void merge(int beginingIndex,int midIndex,int endingIndex){
        int leftSortedArraySize = (midIndex - beginingIndex)+1;
        int rightSortedArraySize = (endingIndex - midIndex);
        int[] leftSortedArray = new int[leftSortedArraySize+1];
        for(int i=0;i<leftSortedArraySize;i++){
            leftSortedArray[i] = array[beginingIndex+i];
        }
        leftSortedArray[leftSortedArraySize] = Integer.MAX_VALUE;
        int[] rightSortedArray = new int[rightSortedArraySize+1];
        for (int i=0;i<rightSortedArraySize;i++){
            rightSortedArray[i] = array[midIndex+1+i];
        }
        rightSortedArray[rightSortedArraySize] = Integer.MAX_VALUE;
        int leftSortedArrayIndex = 0;
        int rightSortedArrayIndex = 0;
        for(int i=beginingIndex;i<=endingIndex;i++){
            if(leftSortedArray[leftSortedArrayIndex]<=rightSortedArray[rightSortedArrayIndex]){
                array[i] = leftSortedArray[leftSortedArrayIndex];
                leftSortedArrayIndex++;
            }else{
                array[i] = rightSortedArray[rightSortedArrayIndex];
                rightSortedArrayIndex++;
            }
        }
    }
}
