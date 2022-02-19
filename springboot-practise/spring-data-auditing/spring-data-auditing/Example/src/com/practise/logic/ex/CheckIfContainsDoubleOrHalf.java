package com.practise.logic.ex;

import java.util.*;

/**
 * @author MithileshB
 * @created 26/10/2021 - 8:14 PM
 * @project Example
 */
public class CheckIfContainsDoubleOrHalf {

    public static void main(String[] args) {
        int a[]={10,2,9,3};
        System.out.println(checkForRequiredCond(a));
    }

    private static boolean checkForRequiredCond(int[] a) {
        Map<Integer,Integer> hm=new HashMap<>();

        Set set=new HashSet();

        for(Integer i:a){
            set.add(i);
        }
        for(int i=0;i<a.length;i++) {
            if (set.contains(a[i] / 2) || set.contains(a[i] * 2)) {
                return true;
            }
        }/*
        Iterator<Integer> itr=set.iterator();
        while (itr.hasNext()){
            if()
        }*/

        return false;
    }
}
