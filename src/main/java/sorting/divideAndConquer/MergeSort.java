package sorting.divideAndConquer;

import sorting.AbstractSorting;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        // Base case: if the subarray has length == 1, it is already sorted
        if (leftIndex >= rightIndex) {
            return;
        }

        // Calculate the middle index to divide the subarray into halves
        int middleIndex = (leftIndex + rightIndex) / 2;

        // Recursively sort the two halves
        sort(array, leftIndex, middleIndex);
        sort(array, middleIndex + 1, rightIndex);

        // Merge the sorted halves back together
        merge(array, leftIndex, middleIndex, rightIndex);
    }

    private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftSize = middleIndex - leftIndex + 1;
        int rightSize = rightIndex - middleIndex;

        // Create temporary arrays to store the left and right halves
        T[] leftArray = (T[]) new Comparable[leftSize];
        T[] rightArray = (T[]) new Comparable[rightSize];

        // Copy the elements from the original array to the temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[leftIndex + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[middleIndex + 1 + j];
        }

        // Merge the temporary arrays back into the original array
        int i = 0; // Index for the leftArray
        int j = 0; // Index for the rightArray
        int k = leftIndex; // Index for the merged array

        while (i < leftSize && j < rightSize) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the leftArray
        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the rightArray
        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
