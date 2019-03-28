package com.cs.algorithms;

public class QuickSelect {

    public void testQuickSelect(){
        int[] arr = {1,2,3,4,5,6,7,8};
        int k = kthSmallestElement(arr,0, arr.length-1, 2);
        System.out.println(k);
    }

    public int kthSmallestElement(int [] arr, int low, int high, int k){
        if (k < 0 || k - 1 > high){
            return Integer.MAX_VALUE;
        }
        int pivot = partition(arr,low, high);
        if (pivot == k - 1){
            return arr[pivot];
        }else if (pivot > k - 1){
            return kthSmallestElement(arr, low, pivot - 1,k);
        }
        return kthSmallestElement(arr, pivot + 1, high, k);
    }

    public int partition(int[] arr, int low, int high){
        int pivot = high;
        int i = low-1;
        for(int j = low; j < high; j++){
            if(arr[j] < arr[pivot]){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i+1;
    }
    void swap(int nums[], int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
