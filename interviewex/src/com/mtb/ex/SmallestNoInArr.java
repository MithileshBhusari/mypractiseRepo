package com.mtb.ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author MithileshB
 * @created 27/11/2021 - 2:47 PM
 * @project interviewex
 *
 *
 * # Find the 1st and 2nd smallest number in array
 * [1, 4 , 3, 0, 6, 5, 2]
 */
public class SmallestNoInArr {

    public static void main(String[] args) {

        int arr[]={1, 4 , 3, 0, 6, 5, 2};
        findSmallest(arr);
    }

    private static void findSmallest(int[] arr) {
       int firstSmallest;
       int secondSmallest;

            if(arr[0]>arr[1]){
                firstSmallest=arr[0];
                secondSmallest=arr[0];
            }else{
                firstSmallest=arr[0];
                secondSmallest=arr[0];

            }
       for(int i=0;i<arr.length;i++){
            if(arr[i]<firstSmallest){
                firstSmallest=arr[i];
            }
            if(arr[i]>firstSmallest && arr[i]<secondSmallest){
                secondSmallest=arr[i];
            }
          /*  if(firstSmallest>=secondSmallest){
             int temp=firstSmallest;
                firstSmallest=secondSmallest;
                secondSmallest=temp;
            }*/
       }
        System.out.println("firstSmallest:"+firstSmallest);
        System.out.println("secondSmallest:"+secondSmallest);
    }

}
