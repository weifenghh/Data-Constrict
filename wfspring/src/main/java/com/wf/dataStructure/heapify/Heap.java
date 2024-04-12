package com.wf.dataStructure.heapify;

import java.util.Arrays;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/11 8:25
 * @Package com.wf.dataStructure.heapify
 * @Version 1.0
 * @Since 1.0
 */
public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap(5, true);
        for (int i = 1; i <= 10; i++){
            heap.offer(i);
            System.out.println(Arrays.toString(heap.array));
        }
    }

    int[] array;
    int size;
    boolean max;

    public int size(){return size;}

    public Heap(int capacity, boolean max){
        this.array = new int[capacity];
        this.max = max;
    }

    public int peek(){return array[0];}

    public int poll(){
        int top = array[0];
        swap(0,size-1);
        size--;
        return top;
    }

    public boolean offer(int offered){
        if(size == array.length){
            grow();
        }
        up(offered);
        size++;
        return true;
    }

    //扩容
    private void grow(){
        int capacity = size + (size >> 1);
        int[] newArray = new int[capacity];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;
    }

    public boolean replace(int offered){
        if(size == 0){
            return false;
        }
        array[0] = offered;
        down(0);
        return true;
    }

    private void up(int offered){
        int child = size;
        while(child > 0){
            int parent = (child - 1) / 2;
            boolean cmp = max ? offered > array[parent] : offered < array[parent];
            if(cmp){
                array[child] = array[parent];
            }else{
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    private void down(int parent){
        int maxOrMin = parent;
        int left = parent * 2 + 1;
        int right = left + 1;
        if(left < size && (max ? array[left] > array[maxOrMin] : array[left] < array[maxOrMin])){
            maxOrMin = left;
        }
        if(right < size && (max ? array[right] > array[maxOrMin] : array[right] < array[maxOrMin])){
            maxOrMin = right;
        }
        if(maxOrMin != parent){
            swap(maxOrMin, parent);
            down(maxOrMin);
        }
    }

    private void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
