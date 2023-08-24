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
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
/*public void sort(T[] array, int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {
        int pivotIndex = medianOfThree(array, leftIndex, rightIndex);
        swap(array, pivotIndex, rightIndex - 1);
        
        int i = leftIndex;
        int j = rightIndex - 1;
        
        while (i <= j) {
            while (array[i].compareTo(array[rightIndex - 1]) < 0) {
                i++;
            }
            
            while (array[j].compareTo(array[rightIndex - 1]) > 0) {
                j--;
            }
            
            if (i < j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        
        swap(array, i, rightIndex - 1);
        
        sort(array, leftIndex, i - 1);
        sort(array, i + 1, rightIndex);
    }
}

private int medianOfThree(T[] array, int leftIndex, int rightIndex) {
    int centerIndex = (leftIndex + rightIndex) / 2;
    if (array[leftIndex].compareTo(array[centerIndex]) > 0) {
        swap(array, leftIndex, centerIndex);
    }
    if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
        swap(array, leftIndex, rightIndex);
    }
    if (array[centerIndex].compareTo(array[rightIndex]) > 0) {
        swap(array, centerIndex, rightIndex);
    }
    return centerIndex;
}

private void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
 */