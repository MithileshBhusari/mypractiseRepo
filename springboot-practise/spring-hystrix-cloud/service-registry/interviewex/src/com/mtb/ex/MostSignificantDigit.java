package com.mtb.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MithileshB
 * @created 06/12/2021 - 7:53 AM
 * @project interviewex
 */
public class MostSignificantDigit {
    public static void main(String[] args) {
    int arr[] = {1, 2, 4};
        List<Integer> collect = Arrays.stream(arr)
                .boxed().collect(Collectors.toList());
        int N=arr.length;
        MostSignificantDigit ob = new MostSignificantDigit();
        List<Integer> res = ob.increment(collect,N);

        for(int i=0; i<res.size(); i++)
            System.out.print(res.get(i) + " ");
        System.out.println();
    }
    static List<Integer> increment(List<Integer> arr , int N) {
        arr.set(N-1,arr.get(N-1)+1);
        int carry=arr.get(N-1)/10;
        arr.set(N-1,arr.get(N-1)%10);
        for(int i=N-2;i>=0;i--){
            if(carry==1){
                arr.set(i,arr.get(i)+1);
                carry=arr.get(i)/10;
                arr.set(i,arr.get(i)%10);
            }
        }
        if(carry==1){
            arr.add(0,1);
        }
        return arr;
    }
}
