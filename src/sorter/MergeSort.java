package sorter;

import java.util.Arrays;

class MergeSort extends Sorters {
	public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        T[] tempArray = Arrays.copyOf(array, array.length);
        mergeSort(array, tempArray, 0, array.length - 1);
	}
    private static <T extends Comparable<T>> void mergeSort(T[] array, T[] tempArray, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, tempArray, leftStart, middle);
        mergeSort(array, tempArray, middle + 1, rightEnd);
        mergeHalves(array, tempArray, leftStart, rightEnd);
    }

    private static <T extends Comparable<T>> void mergeHalves(T[] array, T[] tempArray, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left].compareTo(array[right]) <= 0) {
                tempArray[index] = array[left];
                left++;
            } else {
                tempArray[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, tempArray, index, leftEnd - left + 1);
        System.arraycopy(array, right, tempArray, index, rightEnd - right + 1);
        System.arraycopy(tempArray, leftStart, array, leftStart, rightEnd - leftStart + 1);
    }
}