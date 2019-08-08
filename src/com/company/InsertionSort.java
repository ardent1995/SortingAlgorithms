package com.company;

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size;i++){
            System.out.print("Enter "+(i+1)+"th element: ");
            array[i] = scanner.nextInt();
        }
        int[] sortedArray = insertionSort(array);
        System.out.print("Sorted elements are: ");
        for(int i= 0;i<sortedArray.length;i++){
            if(i == sortedArray.length - 1) {
                System.out.print(sortedArray[i]);
            }else {
                System.out.print(sortedArray[i]+",");
            }
        }
    }

    private static int[] insertionSort(int[] array){
        for(int i=1;i<array.length;i++){
            int key = array[i];
            int j = i-1;
            while(j>=0 && array[j]>key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }
}
