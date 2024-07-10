package sorter;

public class Sorter{
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
    public void heapsort(long[] array){
    	heapSort.sort(array);
    }
    public void bubblesort(long[] array){
    	bubbleSort.sort(array);
    }
    public void insertionsort(long[] array){
    	insertionSort.sort(array);
    }
    public void selectionsort(long[] array){
    	selectionSort.sort(array);
    }
    public void mergesort(long[] array){
    	mergeSort.sort(array);
    }
    public void quicksort(long[] array){
    	quickSort.sort(array);
    }
    public Sorter() {
        initializeSorters();
    }
}
