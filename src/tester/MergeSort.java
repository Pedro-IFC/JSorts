package tester;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    
    private static int comparisons = 0;
    private static int swaps = 0;

    // Função principal para ordenar usando o MergeSort e contar comparações e trocas
    public static void mergeSort(int[] arr) {
        comparisons = 0;
        swaps = 0;
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, middle);
        mergeSort(arr, temp, middle + 1, rightEnd);
        merge(arr, temp, leftStart, rightEnd);
    }

    private static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            comparisons++;
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
                swaps++;
            }
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
    }

    // Função para criar um vetor aleatório
    public static int[] createRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100); // Números aleatórios até 100 para simplificação
        }
        return arr;
    }

    // Função para criar um vetor ordenado
    public static int[] createSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // Função para criar um vetor invertido
    public static int[] createReversedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    // Função para medir o desempenho do MergeSort em diferentes tipos de arrays
    public static void measurePerformance(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        long startTime = System.nanoTime();
        mergeSort(copy);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Tempo em milissegundos

        System.out.println("Tipo de Array: " + getType(arr));
        System.out.println("Tamanho do Array: " + arr.length);
        System.out.println("Tempo gasto (ms): " + duration);
        System.out.println("Número de comparações: " + comparisons);
        System.out.println("Número de trocas: " + swaps);
        System.out.println();
    }

    private static String getType(int[] arr) {
        if (isSorted(arr)) {
            return "Ordenado";
        } else if (isReversed(arr)) {
            return "Invertido";
        } else {
            return "Aleatório";
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isReversed(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] sizes = {100000, 1000000};

        for (int size : sizes) {
            int[] randomArray = createRandomArray(size);
            int[] sortedArray = createSortedArray(size);
            int[] reversedArray = createReversedArray(size);

            measurePerformance(randomArray);
            measurePerformance(sortedArray);
            measurePerformance(reversedArray);
        }
    }
}
