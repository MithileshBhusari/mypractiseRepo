package com.mtb.ex;

/**
 * @author MithileshB
 * @created 28/01/2022 - 11:38 PM
 * @project interviewex
 */
public class JewelsAndStones {
    public static int numJewelsInStones(String J,String S){
        int num_jewels=0;
        for(int i=0;i<S.length();i++){
            if(J.indexOf(S.charAt(i))>-1){
                num_jewels+=1;
            }
        }
        return num_jewels;
    }
    public static void main(String[] args){
        String j="aA";
        String s="aAAaaddvdb";
        System.out.println(numJewelsInStones(j,s));
    }
}
