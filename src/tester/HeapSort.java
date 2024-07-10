package tester;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

    // Função principal para ordenar um vetor usando HeapSort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Construir heap (reorganizar o array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extrair elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o final do array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Chama max heapify no heap reduzido
            heapify(arr, i, 0);
        }
    }

    // Função para construir o heap máximo
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Inicializa o maior como raiz
        int l = 2 * i + 1; // Filho da esquerda
        int r = 2 * i + 2; // Filho da direita

        // Se o filho da esquerda é maior que a raiz
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Se o filho da direita é maior que o maior até agora
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Se o maior não é a raiz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente heapify o subárvore afetada
            heapify(arr, n, largest);
        }
    }

    // Função para criar um vetor aleatório de tamanho n
    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100); // números aleatórios até 100
        }
        return arr;
    }

    // Função para criar um vetor ordenado de tamanho n
    public static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // números ordenados de 1 até n
        }
        return arr;
    }

    // Função para criar um vetor inversamente ordenado de tamanho n
    public static int[] generateReversedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i; // números ordenados de n até 1
        }
        return arr;
    }

    // Função para contar o número de trocas e comparações durante o HeapSort
    public static int[] countHeapSortOperations(int[] arr) {
        int[] operations = new int[2]; // operations[0] = comparações, operations[1] = trocas
        heapSortHelper(arr, operations);
        return operations;
    }

    // Função auxiliar para contar operações durante o HeapSort recursivamente
    private static void heapSortHelper(int[] arr, int[] operations) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyHelper(arr, n, i, operations);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyHelper(arr, i, 0, operations);
        }
    }

    // Função auxiliar para heapify e contar operações
    private static void heapifyHelper(int[] arr, int n, int i, int[] operations) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        operations[0]++; // contagem de comparações

        if (l < n && arr[l] > arr[largest])
            largest = l;

        operations[0]++; // contagem de comparações

        if (r < n && arr[r] > arr[largest])
            largest = r;

        operations[0]++; // contagem de comparações

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            operations[1]++; // contagem de trocas

            heapifyHelper(arr, n, largest, operations);
        }
    }

    // Função principal para executar e analisar o desempenho
    public static void main(String[] args) {
        int[] sizes = {100000, 1000000}; // tamanhos dos vetores

        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size);
            int[] sortedArray = generateSortedArray(size);
            int[] reversedArray = generateReversedArray(size);

            // Medição de desempenho para vetores aleatórios
            long startTime = System.nanoTime();
            int[] randomCopy = Arrays.copyOf(randomArray, randomArray.length);
            heapSort(randomCopy);
            long endTime = System.nanoTime();
            long randomTime = endTime - startTime;
            System.out.println("HeapSort em vetor aleatório de tamanho " + size + ":");
            System.out.println("Tempo: " + randomTime / 1e6 + " ms");
            int[] randomOperations = countHeapSortOperations(randomCopy);
            System.out.println("Comparações: " + randomOperations[0]);
            System.out.println("Trocas: " + randomOperations[1]);

            // Medição de desempenho para vetores ordenados
            startTime = System.nanoTime();
            int[] sortedCopy = Arrays.copyOf(sortedArray, sortedArray.length);
            heapSort(sortedCopy);
            endTime = System.nanoTime();
            long sortedTime = endTime - startTime;
            System.out.println("HeapSort em vetor ordenado de tamanho " + size + ":");
            System.out.println("Tempo: " + sortedTime / 1e6 + " ms");
            int[] sortedOperations = countHeapSortOperations(sortedCopy);
            System.out.println("Comparações: " + sortedOperations[0]);
            System.out.println("Trocas: " + sortedOperations[1]);

            // Medição de desempenho para vetores inversamente ordenados
            startTime = System.nanoTime();
            int[] reversedCopy = Arrays.copyOf(reversedArray, reversedArray.length);
            heapSort(reversedCopy);
            endTime = System.nanoTime();
            long reversedTime = endTime - startTime;
            System.out.println("HeapSort em vetor inversamente ordenado de tamanho " + size + ":");
            System.out.println("Tempo: " + reversedTime / 1e6 + " ms");
            int[] reversedOperations = countHeapSortOperations(reversedCopy);
            System.out.println("Comparações: " + reversedOperations[0]);
            System.out.println("Trocas: " + reversedOperations[1]);
            System.out.println();
        }
    }

}
