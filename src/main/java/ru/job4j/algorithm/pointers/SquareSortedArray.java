package ru.job4j.algorithm.pointers;

import java.util.Arrays;

/***
 * Дан отсортированный массив от большего к меньшему.
 * Нужно возвести каждый элемент в квадрат,
 * чтобы результирующий массив был тоже отсортирован.
 * В задаче нужно использовать алгоритм двух указателей.
 */

public class SquareSortedArray {
    public static int[] squareSortedArray(int[] array) {
        int length = array.length;
        int[] result = new int[length];
        int left = 0;
        int right = length - 1;
        int currPos = 0;

        while (left < right) {
            if (Math.abs(array[left]) <= Math.abs(array[right])) {
                result[currPos++] = array[right] * array[right--];
            } else {
                result[currPos++] = array[left] * array[left++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {-4, -2, -1, 0, 2, 3, 5};
        System.out.println(Arrays.toString(squareSortedArray(array)));
    }
}
