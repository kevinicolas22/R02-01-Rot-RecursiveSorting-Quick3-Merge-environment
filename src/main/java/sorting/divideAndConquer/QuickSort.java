package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) { // Step 1
            int pivotIndex = partition(array, leftIndex, rightIndex); // Step 2-3
            sort(array, leftIndex, pivotIndex - 1); // Step 4
            sort(array, pivotIndex + 1, rightIndex); // Step 4
        }
    }

    private int partition(T[] array, int leftIndex, int rightIndex) {
        T pivot = array[leftIndex]; // Step 2
        int i = leftIndex;

        for (int j = leftIndex + 1; j <= rightIndex; j++) {
            if (array[j].compareTo(pivot) < 0) { // Step 3
                i++;
                swap(array, i, j);
            }
        }

        swap(array, leftIndex, i); // Moves pivot to its final sorted position
        return i; // Returns pivot index
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
