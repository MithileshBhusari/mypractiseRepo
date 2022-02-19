package com.mtb.ex;

/**
 * @author MithileshB
 * @created 07/01/2022 - 7:29 AM
 * @project interviewex
 */
public class PalindromeCheck {

        public static void main(String[] args){

            System.out.println("Is 121 is palindrome:"+isPalindrome(13531));

        }

        public static boolean isPalindrome(int x){
            if(x==0){
                return true;
            }
            if(x<0 || x%10==0){
                return false;
            }

            int reversed=0;
            while(x>reversed){
                int pop=x%10;
                x/=10;
                reversed=(reversed*10)+pop;
            }
            if(x==reversed ||x==reversed/10){
                return true;
            }else{
                return false;
            }
        }
}
