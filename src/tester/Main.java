package tester;
import java.util.Random;

import sorter.*;

public class Main {

    public static void main(String[] args) {
        int[] tamanhos = { 100000, 1000000 };
        QuickSort quickSort = new QuickSort();

        for (int tamanho : tamanhos) {
            // Vetor aleatório
            int[] vetorAleatorio = VetorUtil.vetorAleatorio(tamanho);
            long startTime = System.nanoTime();
            quickSort.sort(vetorAleatorio);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Vetor aleatório - Tamanho: " + tamanho + ", Tempo (ms): " + duration / 1000000);

            // Vetor ordenado
            int[] vetorOrdenado = VetorUtil.vetorOrdenado(tamanho);
            startTime = System.nanoTime();
            quickSort.sort(vetorOrdenado);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Vetor ordenado - Tamanho: " + tamanho + ", Tempo (ms): " + duration / 1000000);

            // Vetor invertido
            int[] vetorInvertido = VetorUtil.vetorInvertido(tamanho);
            startTime = System.nanoTime();
            quickSort.sort(vetorInvertido);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Vetor invertido - Tamanho: " + tamanho + ", Tempo (ms): " + duration / 1000000);
        }
    }
}