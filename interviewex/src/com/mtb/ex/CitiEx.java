package com.mtb.ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MithileshB
 * @created 29/11/2021 - 7:41 PM
 * @project interviewex
 */
public class CitiEx {
    public static void main(String[] args) {
        int a[] = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        findSolution(a);
    }

    private static void findSolution(int[] arr) {

        int a[]=new int[arr.length];
        int temp=Integer.MIN_VALUE;
        int velocity = 0;
        boolean flag=false;
        for (int i = 0; i < arr.length; i++) {
            int count=0;
            for(int j=i+1;j<arr.length;j++) {
                if (!flag) {
                    temp=arr[j]-arr[j-1];
                    flag=true;
                    count++;
                    }else if(arr[j]-arr[j-1]==temp){
                    count++;
                }else{
                    break;
                }
            }
        a[i]=count;
        }
        for(int i=0;i<a.length;i++){
            if(a[i]>=3){
                velocity=velocity+(a[i]-2);
            }
        }
        System.out.println("velocity:"+velocity);
    }
}
