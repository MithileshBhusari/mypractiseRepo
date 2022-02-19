package com.mtb.ex;

/**
 * @author MithileshB
 * @created 09/01/2022 - 6:14 PM
 * @project interviewex
 */
public class BinarySearchEx {
    public static int search(int[] nums,int target){
        if(nums.length==0)
            return -1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int midpoint=left+(right-left)/2;
            if(nums[midpoint]==target){
                return midpoint;
            }else if(nums[midpoint]>target){
                right=midpoint-1;
            }else{
                left=midpoint+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int num[]={1,2,4,6,3,9,8};
        int target=5;
        int result=search(num,target);
        if(result>0){
            System.out.println("Element "+target+" found at index "+result);
        }else{
            System.out.println("Element "+target+" not present in given array");
        }
    }
}
