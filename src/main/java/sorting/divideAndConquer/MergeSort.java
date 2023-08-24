package sorting.divideAndConquer;

import sorting.AbstractSorting;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        
        if (leftIndex >= rightIndex) {
            return;
        }

        int middleIndex = (leftIndex + rightIndex) / 2;

        sort(array, leftIndex, middleIndex);
        sort(array, middleIndex + 1, rightIndex);

        merge(array, leftIndex, middleIndex, rightIndex);
    }

    private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftSize = middleIndex - leftIndex + 1;
        int rightSize = rightIndex - middleIndex;

        T[] leftArray = (T[]) new Comparable[leftSize];
        T[] rightArray = (T[]) new Comparable[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[leftIndex + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[middleIndex + 1 + j];
        }

        int i = 0; 
        int j = 0;
        int k = leftIndex; 

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

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
