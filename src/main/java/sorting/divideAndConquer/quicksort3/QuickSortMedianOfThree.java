package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

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

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int[] performPartition(T[] array, int left, int right) {
        T pivot = array[left];
        int lowPointer = left;
        int currentPointer = left;
        int highPointer = right;

        while (currentPointer <= highPointer) {
            int comparison = array[currentPointer].compareTo(pivot);
            if (comparison < 0) {
                swap(array, lowPointer++, currentPointer++);
            } else if (comparison > 0) {
                swap(array, highPointer--, currentPointer);
            } else {
                currentPointer++;
            }
        }

        return new int[] { lowPointer, highPointer };
    }

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= 0 && rightIndex <= array.length - 1 && leftIndex < rightIndex) {
            int[] pivotIndices = performPartition(array, leftIndex, rightIndex);
            sort(array, leftIndex, pivotIndices[0] - 1);
            sort(array, pivotIndices[1] + 1, rightIndex);
        }
    }
}

