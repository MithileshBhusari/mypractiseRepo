package com.mtb.ex;

import java.util.stream.IntStream;

/**
 * @author MithileshB
 * @created 03/02/2022 - 9:44 PM
 * @project interviewex
 */
public class SoryArrayByParityEx {
    public static int[] sortArrayByParity(int [] arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]%2>arr[j]%2){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            if(arr[i]%2==0)i++;
            if(arr[j]%2==1)j--;
        }
        return arr;
    }
    public static int[] sortByParityApproach2(int[] arr){
        int[] result=new int[arr.length];
        int counter=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                result[counter++]=arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==1){
                result[counter++]=arr[i];
            }
        }
        return result;
    }
    public static char findTheDifference(String s, String t) {
        int sourceSum=0;
        int targetSum=0;
        for(char c:s.toCharArray()){
            sourceSum+=c-'a';
        }
        for(char c:t.toCharArray()){
            targetSum+=c-'a';
        }
        return (char) ('a'+targetSum-sourceSum);
    }
    public static void main(String[] args){
        int[] arr={4,3,5,2,6,7,19,20};
        int[] result=sortArrayByParity(arr);

        int [] arr1={3,0,1};
        int i=0;
        //boolean b = IntStream.of(arr1).anyMatch(n -> n != i++);
        int[] result1=sortByParityApproach2(arr);
        /*for(int i:result1){
            System.out.print(i+" ");
        }*/
        System.out.println(findTheDifference("abcd","abcde"));
        //System.out.println(sortArrayByParity(arr));
    }
}
