package com.mtb.ex;

/**
 * @author MithileshB
 * @created 06/12/2021 - 7:37 AM
 * @project interviewex
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int nums[] = {10, 3, 5, 6, 2};
        int n=nums.length;
        productExceptSelf(nums,n);
    }

    public static long[] productExceptSelf(int nums[], int n)
    {
        long prod[] = new long[n];
        if (n == 1) {
            prod[0]=1;
            return prod;
        }
        int i;
        long temp = 1;
        for (int j = 0; j < n; j++){
            prod[j] = 1;
        }
        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= nums[i];
        }
        return prod;
    }
}
