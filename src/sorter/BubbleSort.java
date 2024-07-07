package sorter;


public class BubbleSort extends Sorters {
    public <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        boolean trocado;
        do {
        	trocado = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    T aux = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = aux;
                    trocado = true;
                }
            }
            n--;
        } while (trocado);
    }
}
