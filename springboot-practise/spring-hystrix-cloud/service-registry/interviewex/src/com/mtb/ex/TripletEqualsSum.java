package com.mtb.ex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author MithileshB
 * @created 11/02/2022 - 6:15 PM
 * @project interviewex
 */
public class TripletEqualsSum {
    public static void main(String[] args) {
        int[] arr=new int[]{1,4,45,6,10,8};

        int sum=13;
        getTriplet(arr,sum);
        getTriplet1(arr,sum);
    }

    private static void getTriplet(int[] arr, int sum) {
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k]==sum){
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                    }
                }
            }
        }
    }
    private static void getTriplet1(int [] arr,int sum){
        Set<Integer> set=new HashSet<>();
        set.add(arr[0]);
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int curr=sum-(arr[i]+arr[j]);
                if(set.contains(curr)){
                    System.out.println(curr+" "+arr[i]+" "+arr[j]);
                }else{
                    set.add(arr[j]);
                }
            }
        }
    }
}
