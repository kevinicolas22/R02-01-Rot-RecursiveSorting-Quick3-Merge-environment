package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {

    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotIndex = medianOfThree(array, leftIndex, rightIndex);
            pivotIndex = partition(array, leftIndex, rightIndex, pivotIndex);
            sort(array, leftIndex, pivotIndex - 1);
            sort(array, pivotIndex + 1, rightIndex);
        }
    }

    private int medianOfThree(T[] array, int left, int right) {
        int center = (left + right) / 2;

        if (array[left].compareTo(array[center]) > 0) {
            swap(array, left, center);
        }
        if (array[left].compareTo(array[right]) > 0) {
            swap(array, left, right);
        }
        if (array[center].compareTo(array[right]) > 0) {
            swap(array, center, right);
        }

        swap(array, center, right - 1); // Move pivot to right-1

        return right - 1; // Return pivot index
    }

    private int partition(T[] array, int left, int right, int pivotIndex) {
        T pivotValue = array[pivotIndex];
        int leftPointer = left;
        int rightPointer = right - 1;

        while (true) {
            while (array[++leftPointer].compareTo(pivotValue) < 0);
            while (array[--rightPointer].compareTo(pivotValue) > 0);
            
            if (leftPointer >= rightPointer) {
                break;
            } else {
                swap(array, leftPointer, rightPointer);
            }
        }

        // Restore pivot to its original position
        swap(array, leftPointer, right - 1);

        return leftPointer;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

