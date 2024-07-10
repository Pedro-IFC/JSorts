package sorter;

import java.util.Arrays;

public class MergeSort implements Sorters {
    public void sort(long[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        long[] auxArray = Arrays.copyOf(array, array.length);
        mergeSort(array, auxArray, 0, array.length - 1);
    }

    private static void mergeSort(long[] array, long[] auxArray, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, auxArray, leftStart, middle);
        mergeSort(array, auxArray, middle + 1, rightEnd);
        mergeHalves(array, auxArray, leftStart, rightEnd);
    }

    private static void mergeHalves(long[] array, long[] auxArray, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                auxArray[index] = array[left];
                left++;
            } else {
                auxArray[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, auxArray, index, leftEnd - left + 1);
        System.arraycopy(array, right, auxArray, index, rightEnd - right + 1);
        System.arraycopy(auxArray, leftStart, array, leftStart, rightEnd - leftStart + 1);
    }
}
