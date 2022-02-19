package com.mtb.ex;

/**
 * @author MithileshB
 * @created 03/12/2021 - 6:42 AM
 * @project interviewex
 */
public class CountWaysGfG {
    public static void main(String[] args) {
        String a="GeeksforGeeks";
        String b="Gks";

        System.out.println(count(a,b,a.length(),b.length()));
    }

    private static int count(String a, String b, int m, int n) {
        if((m==0 && n==0) || n==0){
            return 1;
        }
        if(m==0)
            return 0;

        if(a.charAt(m-1)==b.charAt(n-1)){
            return count(a,b,m-1,n-1)+
                    count(a,b,m-1,n);
        }else{
            return count(a,b,m-1,n);
        }
    }
}
