package ru.job4j.algorithm;

import java.util.Arrays;

/***
 * Вам необходимо разработать алгоритм нахождение наименьшего диапазона
 * с данным количеством различных элементов
 *
 * У вас есть отсортированный массив целых чисел и число k.
 * Ваша задача - найти наименьший диапазон в массиве,
 * который содержит как минимум k различных элементов. Например:
 *
 * входной массив [1, 2, 3, 4, 5] и k = 3, то наименьший диапазон будет [0, 2],
 * так как он содержит три различных элемента: 1, 2 и 3.
 *
 * входной массив [1, 2, 2, 3, 4, 5] и k = 3, то наименьший диапазон будет [2, 4],
 * так как он содержит три различных элемента: 2, 3 и 4. Диапазон [0, 2] не подходит,
 * так как он содержит дублирующие элементы 1, 2, 2.
 */

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        int startPos = 0;
        int currUniqueElement = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                if (++currUniqueElement == k) {
                    return new int[]{startPos, startPos + k - 1};
                }
            } else {
                currUniqueElement = 1;
                startPos = i;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
