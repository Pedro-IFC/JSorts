package tester;

import java.util.Arrays;
import java.util.Random;

class QuickSort {
    // Função principal de ordenação usando Quicksort
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quicksort(array, 0, array.length - 1);
    }

    // Função recursiva de Quicksort
    private void quicksort(int[] array, int low, int high) {
        int i = low, j = high;
        // Pivô é o elemento do meio
        int pivot = array[low + (high - low) / 2];

        // Dividir o array em duas partes
        while (i <= j) {
            // Encontrar elementos maiores que o pivô
            while (array[i] < pivot) {
                i++;
            }
            // Encontrar elementos menores que o pivô
            while (array[j] > pivot) {
                j--;
            }

            // Trocar elementos, mover para próximo par de índices
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // Recursivamente ordenar as duas partes
        if (low < j) {
            quicksort(array, low, j);
        }
        if (i < high) {
            quicksort(array, i, high);
        }
    }
}
