package com.mtb.ex;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MithileshB
 * @created 25/01/2022 - 1:46 AM
 * @project interviewex
 */
public class LSWGE {

    public static void main(String[] args) {
        int [] arr={3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
        int k=5;
        solution(arr,k);
    }
    private static int solution(int[] arr,int k){
        int ans=0;
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        for(int i=0;i< arr.length;i++){
            sum+=arr[i];
            if (hm.containsKey(sum - k)) {
                ans+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
