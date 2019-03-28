package com.cs.algorithms;


import com.cs.utils.Utils;

public class QuickSort {

    public void testQuickSort() {
//        int[] arr = new int[]{3, 4, 1, 6, 92, 10};
        int[] arr = new int[]{1, 2, 3, 3, 4};
        quickSort(arr, 0, arr.length - 1);
        Utils.printArray(arr);
    }

    void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    // Partitioning using pivot as the last element

    int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return end;
    }

    void swap(int nums[], int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }


    /**/
}

