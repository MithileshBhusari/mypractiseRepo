package com.mtb.ex;

/**
 * @author MithileshB
 * @created 06/02/2022 - 1:21 AM
 * @project interviewex
 */
public class MinSubArrayLenEx {


    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        System.out.println(maxSubArrayLenth(7,new int[]{2,3,1,2,1,1,1,1,3}));
    }
        public static int minSubArrayLen(int s,int[] nums){
            int result=Integer.MAX_VALUE;

            int left=0;
            int val_sum=0;

            for(int i=0;i<nums.length;i++){
                val_sum+=nums[i];
                while(val_sum>=s){
                    result=Math.min(result,i+1-left);
                    val_sum-=nums[left];
                    left++;
                }
            }
            return result!=Integer.MAX_VALUE?result:0;
        }

        public static int maxSubArrayLenth(int s,int [] arr){
            int result=Integer.MIN_VALUE;
            int left=0;
            int val_sum=0;
            for(int i=0;i<arr.length;i++){
                val_sum+=arr[i];
                while(val_sum>s){
                    //result=Math.max(result,i+1-left);
                    val_sum-=arr[left];
                    left++;
                }
                if(val_sum==s){
                    result=Math.max(result,i+1-left);
                }
            }
            return result!=Integer.MIN_VALUE?result:0;
        }

}
