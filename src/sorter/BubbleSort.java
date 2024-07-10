package sorter;

public class BubbleSort implements Sorters {
    public void sort(long[] array) {
        int n = array.length;
        boolean trocado;
        do {
            trocado = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    long aux = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = aux;
                    trocado = true;
                }
            }
            n--;
        } while (trocado);
    }
}
