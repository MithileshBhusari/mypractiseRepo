package com.mtb.ex;

/**
 * @author MithileshB
 * @created 08/01/2022 - 5:13 PM
 * @project interviewex
 */
public class ReverseInteger {

    public static int reverse(int x){
        int reversed=0;

        while(x!=0){
            x/=10;
            if(reversed>Integer.MAX_VALUE/10 || reversed==Integer.MAX_VALUE/10 && (x%10)>7){
                return 0;
            }
            if(reversed<Integer.MIN_VALUE/10 || reversed==Integer.MIN_VALUE/10 && (x%10)<-8){
                return 0;
            }
            reversed=(reversed*10)+(x%10);
        }
        return reversed;
    }
    public static void main(String[] args){
        System.out.println("Reverse is: "+reverse(1234));
    }
}
