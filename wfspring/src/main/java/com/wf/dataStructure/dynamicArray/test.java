package com.wf.dataStructure.dynamicArray;

import java.util.function.Consumer;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/11 14:46
 * @Package com.wf.dataStructure.dynamicArray
 * @Version 1.0
 * @Since 1.0
 */
public class test {

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 9; i++) {
            dynamicArray.addLast(i + 1);
        }
        dynamicArray.add(3,6);
//        int remove = dynamicArray.remove(3);

        dynamicArray.forEach((element) -> {
            System.out.println(element);
        });
        System.out.println("========================");
        for (Integer element : dynamicArray){
            System.out.println(element);
        }
        System.out.println("========================");
        dynamicArray.stream().forEach(element -> {
            System.out.println(element);
        });

    }

}
