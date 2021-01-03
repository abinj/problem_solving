package com.abin;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2, 6, 3, 1, 7, 5, 9};
        int[] sortedNums = quickSortFn(nums, nums.length -1);
    }

    private static int[] quickSortFn(int[] nums, int pivot) {
        int[] unsortedNums = nums;
        for(int i =0; i< pivot; i++) {
            if(unsortedNums[i] > unsortedNums[pivot]) {
                int tempNum = unsortedNums[i];
                unsortedNums[i] = unsortedNums[pivot - 1];
                unsortedNums[pivot] = tempNum;
            }
        }

        return new int[0];
    }
}
