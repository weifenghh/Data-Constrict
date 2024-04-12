package com.wf.dataStructure.Leetcode;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/23 9:48
 * @Package com.wf.dataStructure.Leetcode
 * @Version 1.0
 * @Since 1.0
 */

import java.util.Arrays;

/**
 * 合并有序列表
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] a1 = {1,5,6,2,4,10,11};
        int[] a2 = new int[a1.length];
        merge(a1,0,2,3,6,a2,0);
        System.out.println(Arrays.toString(a2));
    }

    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2, int k){
        if(i > iEnd){
            System.arraycopy(a1,j,a2,k,jEnd - j + 1);
            return;
        }
        if(j > jEnd){
            System.arraycopy(a1,i,a2, k,iEnd - i + 1);
            return;
        }
        if(a1[i] < a1[j]){
            a2[k] = a1[i];
            merge(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        }
        if(a1[i] > a1[j]){
            a2[k] = a1[j];
            merge(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
    }

}
