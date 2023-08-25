package sorting.divideAndConquer.hybridMergesort;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	private int MERGESORT_APPLICATIONS = 0;
	private int INSERTIONSORT_APPLICATIONS = 0;

        @Override
        public void sort(T[] array, int leftIndex, int rightIndex) {

            MERGESORT_APPLICATIONS = 0;
            INSERTIONSORT_APPLICATIONS = 0;

            if (leftIndex < rightIndex) {
                int size = rightIndex - leftIndex + 1;
                
                if (size <= SIZE_LIMIT) {
                    insertionSort(array, leftIndex, rightIndex);
                    INSERTIONSORT_APPLICATIONS++;
                } else {
                    int middleIndex = (leftIndex + rightIndex) / 2;
                    sort(array, leftIndex, middleIndex);
                    sort(array, middleIndex + 1, rightIndex);
                    merge(array, leftIndex, middleIndex, rightIndex);
                    MERGESORT_APPLICATIONS++;
                }
            }
        }

        private void insertionSort(T[] array, int leftIndex, int rightIndex) {
            for (int i = leftIndex + 1; i <= rightIndex; i++) {
                T current = array[i];
                int j = i - 1;
                
                while (j >= leftIndex && array[j].compareTo(current) > 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                
                array[j + 1] = current;
            }
        }

        private void merge(T[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftSize = middleIndex - leftIndex + 1;
        int rightSize = rightIndex - middleIndex;

        T[] leftArray = Arrays.copyOfRange(array, leftIndex, middleIndex + 1);
        T[] rightArray = Arrays.copyOfRange(array, middleIndex + 1, rightIndex + 1);

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
