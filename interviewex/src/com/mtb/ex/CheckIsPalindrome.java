package com.mtb.ex;

import java.util.Locale;

/**
 * @author MithileshB
 * @created 10/01/2022 - 9:48 PM
 * @project interviewex
 */
public class CheckIsPalindrome {
    public static  boolean isPalindrome(String s){
        String result="";
        for(char c:s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                result+=c;
            }
        }
        result=result.toLowerCase();
        int a_pointer=0;
        int b_pointer=result.length()-1;
        while(a_pointer<=b_pointer){
            if(result.charAt(a_pointer)!=result.charAt(b_pointer)){
                return  false;
            }
            a_pointer+=1;
            b_pointer-=1;
        }
        return true;
    }

    public static boolean isPalindrome(String s,int a_pointer,int b_pointer){
        while(a_pointer<b_pointer){
            if(s.charAt(a_pointer)!=s.charAt(b_pointer)){
                return false;
            }
            a_pointer+=1;
            b_pointer-=1;
        }
        return true;


    }
    public static boolean isValidPalindrome(String s){
        int a_pointer=0;
        int b_pointer=s.length()-1;
        while(a_pointer<b_pointer){
            if(s.charAt(a_pointer)==s.charAt(b_pointer)){
                a_pointer+=1;
                b_pointer-=1;
            }else{
                return isPalindrome(s,a_pointer+1,b_pointer) || isPalindrome(s,a_pointer,b_pointer-1);
            }

        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("isPalindrome:"+isValidPalindrome("abca"));
    }
}
