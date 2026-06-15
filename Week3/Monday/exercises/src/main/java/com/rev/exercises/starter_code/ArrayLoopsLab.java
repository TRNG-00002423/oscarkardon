package com.rev.exercises.starter_code;

import java.util.Arrays;

/**
 * Lab 1 — Arrays & loops. Implement the bodies.
 * See ../README.md
 */
public class ArrayLoopsLab {

    /** Reverse array in place. */
    public static void reverse(int[] data) {
        int temp;
        for (int i = 0; i < data.length / 2; i++) {
            temp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = temp;
        }
    }

    /** Smallest element; illegal if null or empty. */
    public static int min(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("null or empty");
        }
        int min = data[0];
        for(int i = 1; i < data.length; i++){
            if(min > data[i]){
                min = data[i];
            }
        }
        return min;
    }

    /** Largest element; illegal if null or empty. */
    public static int max(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("null or empty");
        }
        int max = data[0];
        for(int i = 1; i < data.length; i++){
            if(max < data[i]){
                max = data[i];
            }
        }
        return max;
    }

    /** In-place ascending sort using nested loops only (no Arrays.sort). */
    public static void sortAscending(int[] data) {
        for(int i = 0; i < data.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < data.length; j++){
                if(data[minIndex] > data[j]){
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int [] testArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(testArray));
        reverse(testArray);
        System.out.println(Arrays.toString(testArray));

        int [] testArray2 = {7, 10, 19, 4, 12, 1};
        System.out.println(Arrays.toString(testArray2));
        reverse(testArray2);
        System.out.println(Arrays.toString(testArray2));

        int min1 = min(testArray);
        System.out.println(min1);
        int min2 = min(testArray2);
        System.out.println(min2);
        int max1 = max(testArray);
        System.out.println(max1);
        int max2 = max(testArray2);
        System.out.println(max2);


        System.out.println(Arrays.toString(testArray));
        sortAscending(testArray);
        System.out.println(Arrays.toString(testArray));

        int [] testArray3 = {7, 10, 19, 4, 12, 1};
        System.out.println(Arrays.toString(testArray3));
        sortAscending(testArray3);
        System.out.println(Arrays.toString(testArray3));

    }
}