package com.mtb.ex;

import java.util.Stack;

/**
 * @author MithileshB
 * @created 01/02/2022 - 11:18 PM
 * @project interviewex
 */
public class ReverseOnlyLettersEx {
    public static String reverseOnlyLetters(String s){
        StringBuilder sb=new StringBuilder();
        int j=s.length()-1;
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                while(!Character.isLetter(s.charAt(j))){
                    j--;
                }
                sb.append(s.charAt(j));
                j--;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String reverseOnlyLettersApproach2(String s){

        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                sb.append(stack.pop());
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseOnlyLetters("a-bcd-eFG-H-Ij"));

        System.out.println(reverseOnlyLettersApproach2("a-bcd-eFG-H-Ij"));
    }
}
