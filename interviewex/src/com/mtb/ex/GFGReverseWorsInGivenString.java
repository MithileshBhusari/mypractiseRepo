package com.mtb.ex;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author MithileshB
 * @created 30/01/2022 - 11:37 AM
 * @project interviewex
 */
public class GFGReverseWorsInGivenString {
    public static void main(String[] args){
        String s="i.like.this.program.very.much";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords1(s.toCharArray()));
    }

    private static String reverseWords(String s) {
     /*   Stack<String> stack=new Stack<>();
        String[] arr=s.split(".");
        StringBuilder result=new StringBuilder();
        stack.addAll(Arrays.asList(arr));
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                result.append(stack.pop());
            }
        }*/
        String[] arr=s.split("\\.");
        StringBuilder result=new StringBuilder();
        for(int i=arr.length-1;i>0;i--){
            result.append(arr[i]+".");
        }
        result.append(arr[0]);

        return result.toString();
    }

    private static char[] reverseWords1(char[] arr){
        int start=0;
        for(int end=0;end<arr.length;end++){
            if(arr[end]=='.'){
                reverse(arr,start,end);
                start=end+1;
            }
        }
        reverse(arr,start,arr.length-1);
        reverse(arr,0,arr.length-1);
        return arr;
    }

    private static void reverse(char[] arr, int start, int end) {
        char temp;
        while(start<=end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
