package sorter;

public class SelectionSort extends Sorters {
    public <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int auxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[auxIndex]) < 0) {
                    auxIndex = j;
                }
            }
            T aux = array[auxIndex];
            array[auxIndex] = array[i];
            array[i] = aux;
        }
    }
}
	