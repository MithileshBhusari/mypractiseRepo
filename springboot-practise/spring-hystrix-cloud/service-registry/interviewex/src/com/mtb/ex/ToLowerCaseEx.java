package com.mtb.ex;

/**
 * @author MithileshB
 * @created 09/01/2022 - 6:24 PM
 * @project interviewex
 */
public class ToLowerCaseEx {

    public static String toLowerCase(String str){
        String result="";
        for(char c:str.toCharArray()){
            if(Character.isUpperCase(c)){
                result+=(char)(c+32);
            }else{
                result+=c;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("To Lowercase:"+toLowerCase("HelloMithilesh"));
    }
}
