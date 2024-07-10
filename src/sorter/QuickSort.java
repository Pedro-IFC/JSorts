package sorter;

public class QuickSort implements Sorters {
    public void sort(long[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(long[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(long[] array, int low, int high) {
        long pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                long temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        long temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
