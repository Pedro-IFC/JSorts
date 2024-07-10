package sorter;

public class SelectionSort implements Sorters {
    public void sort(long[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int auxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[auxIndex]) {
                    auxIndex = j;
                }
            }
            long aux = array[auxIndex];
            array[auxIndex] = array[i];
            array[i] = aux;
        }
    }
}
