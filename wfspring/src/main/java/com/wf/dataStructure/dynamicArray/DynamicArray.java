package com.wf.dataStructure.dynamicArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/11 14:17
 * @Package com.wf.dataStructure.dynamicArray
 * @Version 1.0
 * @Since 1.0
 */
public class DynamicArray implements Iterable<Integer>{

    private int size = 0;   //逻辑大小
    private int capacity = 8;  //初始容量
    private int[] array = {};  //懒加载

    /**
     * addLast：数组的末端加入元素；
     * @param element
     */
    public void addLast(int element){
//        array[size] = element;
//        size++;
        add(size,element);
    }

    /**
     * add：指定位置插入元素
     * @param index
     * @param element
     */
    public void add(int index,int element) {
        checkAndGrow();

        if (index >= 0 && index < size) {
            //将要插入的位置以及之后的元素向后移动一位，空出位置给插入元素
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        //将新元素插入到指定位置
        array[index] = element;
        size++;
    }

    /**
     * checkAndGrow：数组扩容
     */
    private void checkAndGrow() {
        if(size == 0){
            array = new int[capacity];
        }
        //添加之前进行扩容，确保容量充足
        if(size == capacity){
            //capacity ÷ 2^1
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            //将旧数组 复制到新数组中
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }

    /**
     * remove：根据索引 进行指定删除
     * @param index
     * @return
     */
    public int remove(int index){
        int removed = array[index];
        System.arraycopy(array,index + 1,array,index,size - index - 1);
        size--;
        return removed;
    }

    public int get(int index){
        return array[index];
    }

    /**
     * forEach 遍历
     * @param consumer
     */
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 增强for循环遍历
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    /**
     * stream流遍历
     * @return
     */
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }


}
