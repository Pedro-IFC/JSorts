package sorter;

public abstract class Sorters {
    public abstract <T extends Comparable<T>> void sort(T[] array);
}