package com.mtb.ex;


import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
/**
 * @author MithileshB
 * @created 30/12/2021 - 9:04 PM
 * @project interviewex
 */
public class ContainsDuplicateEx {

    public static boolean containsDuplicateApproach2(int[] nums){
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums){
        Set<Integer> numbers=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(numbers.contains(nums[i]))
                return true;
            numbers.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args){
        int[] nums={1,2,3,4};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicateApproach2(nums));
    }
}
