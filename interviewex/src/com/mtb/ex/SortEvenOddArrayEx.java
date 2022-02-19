package com.mtb.ex;

import java.util.PriorityQueue;

/**
 * @author MithileshB
 * @created 06/02/2022 - 6:21 PM
 * @project interviewex
 */
public class SortEvenOddArrayEx {
    public static void main(String[] args) {
        int[] result=sortEvenOddArr(new int[]{36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44,34});
        for(int i:result){
            System.out.print(i+" ");
        }
    }
    public static int[] sortEvenOddArr(int [] nums){
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->a-b);

        for(int i=0;i<nums.length;i+=2){
            minHeap.offer(nums[i]);
        }
        for(int i=1;i<nums.length;i+=2){
            maxHeap.offer(nums[i]);
        }
        int i=0;
        while(!minHeap.isEmpty()){
            nums[i]=minHeap.poll();
            i+=2;
        }
        i=1;
        while(!maxHeap.isEmpty()){
            nums[i]=maxHeap.poll();
            i+=2;
        }
        return nums;
    }
}
