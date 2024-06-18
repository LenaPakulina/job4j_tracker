package ru.job4j.algorithm.pointers;

import java.util.Arrays;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        if (nums.length <= 1 && k != nums[0]) {
            return 0;
        }
        int startPos = 0;
        int totalCount = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > k) {
                sum = sum - nums[startPos++];
            }
            if (sum == k) {
                totalCount++;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        int[] array = {-1, -1, 1};
        System.out.println(subarraySum(array, 0));
    }
}
