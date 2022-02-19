package com.mtb.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author MithileshB
 * @created 24/01/2022 - 8:13 PM
 * @project interviewex
 */
public class LSWGS {

    public static void main(String[] args){
        int []a={10,5,2,7,1,9};
        int sum=15;

        int [] arr={1,2,3,4,5,0,0,0,6,7,8,9,10};
        int s=15;

        int b[]={-5,8,-14,2,4,12};
        int k=-5;

        System.out.println(leng(b,k));
        System.out.println(subArraySum(a,sum));
      //  System.out.println(longestSubArrCountOfSumK(arr,s));
      //  int [] result=longestSubArrOfSumK(arr,s);

    //    System.out.println(minSubArrayLen(k,b));
        /*for(int i=0;i<result.length;i++){
            System.out.print(" "+result[i]);
        }*/
       /* List<Integer> list=new ArrayList(Arrays.asList(longestSubArrOfSumK(a,sum)));
        list.stream().forEach(System.out::print);*/
 //       System.out.println(longestSubArrOfSumK(a,sum));
    }

    public static int leng(int [] arr,int k){
        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0;
        int maxlen=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            if (sum == k) {
                maxlen = i + 1;
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
            if (hm.containsKey(sum - k)) {
                /*if (maxlen < (i - hm.get(sum - k))) {
                    maxlen = i - hm.get(sum - k);
                }*/

                maxlen=Math.max(maxlen,i-hm.get(sum-k));
            }
        }
            return maxlen;
    }

    private static int subArraySum(int[] arr, int k) {
        int result=0;
        int maxLength=Integer.MIN_VALUE;
      int sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        //hm.put(0,1);
      for(int i=0;i<arr.length;i++){
          sum+=arr[i];
          if(sum==k){
              maxLength=i+1;
          }

          if(hm.containsKey(sum-k)){
              result+=hm.get(sum-k);
              maxLength=Math.max(maxLength,i-hm.get(sum-k));
          }
          hm.put(sum,hm.getOrDefault(sum,0)+1);
      }
        return maxLength;
    }
/*

    private static int longestSubArrOfSumK(int[] arr,int sum){
        int result=0;
        int maxLen=0;


        for(int i=0;i<arr.length;i++){
            result+=arr[i];
            if(result==sum){
                maxLen=i+1;
            }
        }



        return result;
    }*/

    private static int[]  longestSubArrOfSumK(int[] arr,int k){
            int sum=0;
            int left=0;
            int right=0;

            int []result=new int[]{-1};
            while(right<arr.length){
                sum+=arr[right];
                while(left<right && sum>k){
                    sum-=arr[left++];
                }
                if(sum==k &&(result.length==1||result[1]-result[0]<right-left )) {
                    result = new int[]{left + 1, right + 1};
                }
                right++;
            }
            return result;
    }



    private static int longestSubArrCountOfSumK(int[] arr,int k){
        int sum=0;
        int left=0;
        int right=0;

        int[] result=new int[]{-1};

        while(right<arr.length){
            sum+=arr[right];
            while(left<right && sum>k){
                sum-=arr[left++];
            }
            if(sum==k &&(result.length==1||result[1]-result[0]<right-left )) {
                result = new int[]{left + 1, right + 1};
            }
            right++;
        }
        return result.length>1?result[1]-result[0]:result[0];
    }

    public static int minSubArrayLen(int s,int[] nums){
        int result=Integer.MAX_VALUE;
        int left=0;
        int curr_sum=0;
        for(int i=0;i<nums.length;i++){
            curr_sum+=nums[i];

            while(curr_sum>=s){
                result=Math.min(result,i+1-left);
                curr_sum-=nums[left];
                left++;
            }
        }
        return (result!=Integer.MAX_VALUE)?result:0;
    }
}
