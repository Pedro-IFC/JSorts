package tester;
import java.util.Arrays;
import java.util.Random;

import sorter.*;

public class Main {

    private static long comparisons;
    private static long swaps;
    
    public static void main(String[] args) {
        int[] sizes = {100000, 1000000};

        for (int size : sizes) {
            int[] sortedArray = createSortedArray(size);
            int[] reversedArray = createReversedArray(size);
            int[] randomArray = createRandomArray(size);

            System.out.println("Sorting array of size: " + size);
            
            analyzePerformance(sortedArray.clone(), "Sorted Array");
            analyzePerformance(reversedArray.clone(), "Reversed Array");
            analyzePerformance(randomArray.clone(), "Random Array");
        }
    }

    private static void analyzePerformance(int[] array, String arrayType) {
        comparisons = 0;
        swaps = 0;
        long startTime = System.nanoTime();
        
        bubbleSort(array);
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
        
        System.out.println(arrayType + ": ");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Time: " + duration + " ms");
        System.out.println();
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    swaps++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private static int[] createSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] createReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    private static int[] createRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }
        return array;
    }
}