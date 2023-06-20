package com.practice;

import java.util.Arrays;

public class RepeatArrayRemove {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 1, 5, 6, 5};

        int length = array.length;
        for (int i = 0; i < length - 1; i++) 
        {
            for (int j = i + 1; j < length; j++) 
            {
                if (array[i] == array[j]) {
                    // Move the last element to the current position
                    array[j] = array[length - 1];
                    length--;
                    j--;
                }
            }
        }

        // Create a new array without duplicates
        int[] newArray = Arrays.copyOf(array, length);

        // Print the array without duplicates
        System.out.println("Array without duplicates: " + Arrays.toString(newArray));
    }
}
