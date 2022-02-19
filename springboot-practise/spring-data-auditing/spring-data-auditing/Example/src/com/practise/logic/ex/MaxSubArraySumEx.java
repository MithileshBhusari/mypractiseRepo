package com.practise.logic.ex;

/**
 * @author MithileshB
 * @created 27/10/2021 - 9:02 AM
 * @project Example
 */
public class MaxSubArraySumEx {

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
    //    System.out.println("Max contigous sum is :" + maxSubArraySumApproach2(a));
        maxSubArraySumApproach3(a);
    }

//Time Complexity= O(n)
    private static int maxSubArraySumApproach1(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }


    private static int maxSubArraySumApproach2(int a[]) {
        int size = a.length;
        int max_so_far = a[0];
        int current_max=a[0];
        for (int i = 0; i < size; i++) {
            current_max=Math.max(a[i],current_max+a[i]);
            max_so_far=Math.max(max_so_far,current_max);
        }
        return max_so_far;
    }

    //Time Complexity = O(n)
    //Auxillay Space=O(1)
    private  static void maxSubArraySumApproach3(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here=0,start=0,end=0,s=0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }

}
