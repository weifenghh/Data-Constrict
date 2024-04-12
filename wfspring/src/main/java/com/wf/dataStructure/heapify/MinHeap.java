package com.wf.dataStructure.heapify;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/10 8:46
 * @Package com.wf.dataStructure.heapify
 * @Version 1.0
 * @Since 1.0
 */
public class MinHeap {

    public static void main(String[] args) {
//        int[] numbers = {3,2,1,5,6,4};
        int[] numbers = {3,2,3,1,3,4,5,5,6};
        int k = 4;
            MinHeap minHeap = new MinHeap(k);
            for (int i = 0; i < k; i++) {
                minHeap.offer(numbers[i]);
            }
            for (int i = k; i < numbers.length; i++) {
                if(numbers[i] > minHeap.peek()){
                    minHeap.replace(numbers[i]);
                }
            }
        System.out.println(minHeap.peek());
    }


    private int size;
    private int[] array;

    public MinHeap(int[] array){
        this.array = array;
        this.size = array.length;
        heapify();
    }
    public MinHeap(int capacity){
        this.array = new int[capacity];
        heapify();
    }

    private void heapify(){
        for(int i = size / 2 - 1; i >= 0; i--){
            down(i);
        }
    }

    public boolean offer(int offered){
        if(size == array.length){
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    public boolean replace(int offered){
        if(size == 0){
            return false;
        }
        array[0] = offered;
        down(0);
        return true;
    }

    public int peek(){
        if(size == 0){
            return -1;
        }
        return array[0];
    }

    private void up(int offered){
        int child = size;
        while(child > 0){
            int parent = (child - 1) / 2;
            if(offered < array[parent]){
                array[child] = array[parent];
            }else{
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    private void down(int parent){
        int min = parent;
        int left = parent * 2 + 1;
        int right = left + 1;
        if(left < size && array[left] < array[min]){
            min = left;
        }
        if(right < size && array[right] < array[min]){
            min = right;
        }
        if(min != parent){
            swap(min, parent);
            down(min);
        }
    }

    private void swap(int min, int parent){
        int temp = array[min];
        array[min] = array[parent];
        array[parent] = temp;
    }

}
