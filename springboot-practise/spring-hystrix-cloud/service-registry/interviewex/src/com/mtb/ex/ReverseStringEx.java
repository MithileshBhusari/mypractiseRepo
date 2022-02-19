package com.mtb.ex;

/**
 * @author MithileshB
 * @created 10/01/2022 - 9:28 PM
 * @project interviewex
 */
public class ReverseStringEx {
        public static char[] reverseString(char[] s){
                int a_pointer=0;
                int b_pointer=s.length-1;

                while(a_pointer<=b_pointer){
                    char temp=s[a_pointer];
                    s[a_pointer]=s[b_pointer];
                    s[b_pointer]=temp;
                    a_pointer+=1;
                    b_pointer-=1;
                }
                return s;
        }
        public static void main(String[] args){
            char []c={'h','e','l','l','o','M'};
            char[] result=reverseString(c);
            for (char ch:result) {
                System.out.print("'"+ch+"',");
            }
        }
}
