package com.wf.dataStructure.heapify;

import java.util.Arrays;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/9 9:39
 * @Package com.wf.dataStructure.heapify
 * @Version 1.0
 * @Since 1.0
 */
public class MaxHeap {

    public static void main(String[] args) {
        int[] array = {2,3,1,7,6,4,5};
        MaxHeap maxHeap = new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.array));

        while(maxHeap.size > 1){
            maxHeap.swap(0, maxHeap.size - 1);
            maxHeap.size--;
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(maxHeap.array));
    }

    private int[] array;
    private int size;

    public MaxHeap(int[] array){
        this.array = array;
        this.size = array.length;
        buildHeap();
    }

    //建堆
    private void buildHeap(){
        for (int i = size / 2 - 1; i >= 0; i--){
            down(i);
        }
    }

    private void down(int parent){
        int max = parent;
        int left = parent * 2 + 1;
        int right = left + 1;
        if(left < size && array[left] > array[max]){
            max = left;
        }
        if(right < size && array[right] > array[max]){
            max = right;
        }
        if(max != parent){
            swap(max,parent);
            down(max);
        }
    }

    private void swap(int max,int parent){
        int temp = array[max];
        array[max] = array[parent];
        array[parent] = temp;
    }

}
