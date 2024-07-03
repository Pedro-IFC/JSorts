package sorter;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
        Integer[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Array original: " + Arrays.toString(array));
        Sorter<Integer> sorter = new Sorter<Integer>();
        sorter.mergesort(array);
        System.out.println("Array ordenado: " + Arrays.toString(array));
	}

}
