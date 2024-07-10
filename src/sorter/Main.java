package sorter;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		long[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Array original: " + Arrays.toString(array));
        Sorter sorter = new Sorter();
        sorter.heapsort(array);
        System.out.println("Array ordenado: " + Arrays.toString(array));
	}

}
