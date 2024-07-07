package tester;

import java.util.Random;

public class SelectionSort {


    public static void main(String[] args) {
        int[] sizes = {100000, 1000000}; // Tamanhos dos vetores
        String[] conditions = {"ordered", "reversed", "random"}; // Condições de ordenação

        for (int size : sizes) {
            for (String condition : conditions) {
                int[] array = generateArray(size, condition);
                long startTime = System.nanoTime();
                long[] stats = selectionSort(array);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000; // Tempo em milissegundos

                System.out.println("Size: " + size + ", Condition: " + condition);
                System.out.println("Comparisons: " + stats[0]);
                System.out.println("Swaps: " + stats[1]);
                System.out.println("Time: " + duration + " ms");
                System.out.println();

                // Aqui você poderia salvar os resultados para posteriormente criar gráficos
                // Exemplo: salvar em um arquivo CSV ou usar uma biblioteca para gráficos
            }
        }
    }

    // Implementação do Selection Sort e retorno das estatísticas
    public static long[] selectionSort(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                swaps++;
            }
        }

        return new long[]{comparisons, swaps};
    }

    // Método para gerar um vetor com a condição especificada
    public static int[] generateArray(int size, String condition) {
        int[] array = new int[size];
        Random random = new Random();

        switch (condition) {
            case "ordered":
                for (int i = 0; i < size; i++) {
                    array[i] = i;
                }
                break;
            case "reversed":
                for (int i = 0; i < size; i++) {
                    array[i] = size - i;
                }
                break;
            case "random":
                for (int i = 0; i < size; i++) {
                    array[i] = random.nextInt(size);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid condition: " + condition);
        }

        return array;
    }
}
