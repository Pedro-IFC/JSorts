package sorter;

public class Sorter<T extends Comparable<T>>{
    private Sorters bubbleSort;
    private Sorters insertionSort;
    private Sorters selectionSort;
    private Sorters mergeSort;
    private Sorters quickSort;
    private Sorters heapSort;
    public void initializeSorters() {
        bubbleSort = new BubbleSort();
        insertionSort = new InsertionSort();
        selectionSort = new SelectionSort();
        mergeSort = new MergeSort();
        quickSort = new QuickSort();
        heapSort = new HeapSort();
    }
    public void heapsort(T[] array){
    	heapSort.sort(array);
    }
    public void bubblesort(T[] array){
    	bubbleSort.sort(array);
    }
    public void insertionsort(T[] array){
    	insertionSort.sort(array);
    }
    public void selectionsort(T[] array){
    	selectionSort.sort(array);
    }
    public void mergesort(T[] array){
    	mergeSort.sort(array);
    }
    public void quicksort(T[] array){
    	quickSort.sort(array);
    }
    public Sorter() {
        initializeSorters();
    }
}
