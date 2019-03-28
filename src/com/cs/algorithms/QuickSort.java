package com.cs.algorithms;


import com.cs.utils.Utils;

public class QuickSort {

    public void testQuickSort() {
        int[] arr = new int[]{3, 4, 1, 6, 92, 10, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
//        int[] arr = new int[]{1, 2, 3, 3, 4};
        quickSortWithThreeWayPartition(arr, 0, arr.length - 1);
        Utils.printArray(arr);
    }

    void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = twoWayPartition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    void quickSortWithThreeWayPartition(int[] nums, int start, int end) {
        if (start < end) {
            int[] pivot = threeWayPartition(nums, start, end);
            quickSort(nums, start, pivot[0] - 1);
            quickSort(nums, pivot[1] + 1, end);
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
        return i + 1;
    }

    void swap(int nums[], int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }


    /* 2 way partitioning*/

    int twoWayPartition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start;
        int j = end + 1;

        while (true) {
            while (nums[++i] < pivot) {
            }
            while (nums[--j] > pivot) {
            }
            swap(nums, i, j);
            if (i >= j) {
                break;
            }
        }
        swap(nums, start, i);
        return i;
    }

    /* 3 way partitioning*/

    int[] threeWayPartition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int lt = start;
        int i = start;
        int gt = end;
        while (i <= gt) {
            if (nums[i] == pivot) {
                i++;
            } else if (nums[i] < pivot) {
                swap(nums, lt, i);
                i++;
                lt++;
            } else {
                swap(nums, i, gt);
                gt--;
            }
        }
        return new int[]{lt, gt};
    }
}

