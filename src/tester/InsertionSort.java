package tester;

public class InsertionSort {

    public static void main(String[] args) {
        int[] sizes = {100000, 1000000}; // Tamanhos dos vetores a serem testados
        String[] descriptions = {"Ordenado", "Invertido", "Aleatório"};

        for (int size : sizes) {
            for (String description : descriptions) {
                int[] array = generateArray(size, description);
                long startTime = System.currentTimeMillis();
                long[] results = insertionSort(array.clone());
                long endTime = System.currentTimeMillis();

                System.out.println("Desempenho do Insertion Sort para vetor " + description + " com " + size + " elementos:");
                System.out.println("Tempo gasto: " + (endTime - startTime) + " ms");
                System.out.println("Número de comparações: " + results[0]);
                System.out.println("Número de trocas: " + results[1]);
                System.out.println();
            }
        }
    }

    // Função para gerar vetores conforme a descrição (Ordenado, Invertido, Aleatório)
    public static int[] generateArray(int size, String description) {
        int[] array = new int[size];

        switch (description) {
            case "Ordenado":
                for (int i = 0; i < size; i++) {
                    array[i] = i;
                }
                break;
            case "Invertido":
                for (int i = 0; i < size; i++) {
                    array[i] = size - i;
                }
                break;
            case "Aleatório":
                for (int i = 0; i < size; i++) {
                    array[i] = (int) (Math.random() * size);
                }
                break;
        }

        return array;
    }

    // Implementação do Insertion Sort que retorna um array com o número de comparações e trocas
    public static long[] insertionSort(int[] array) {
        long comparisons = 0;
        long swaps = 0;

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                comparisons++;
                swaps++;
            }
            array[j + 1] = key;
            comparisons++;
        }

        return new long[]{comparisons, swaps};
    }
}
