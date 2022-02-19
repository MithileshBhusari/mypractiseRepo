package com.mtb.ex;

/**
 * @author MithileshB
 * @created 29/11/2021 - 8:02 PM
 * @project interviewex
 */
public class C2 {
    public static void main(String[] args) {
        int a[]={1,3,5,7,8,9,9,20,25};
        int x=20;
        System.out.println(solution(a,x));
    }
    static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m;
           m= (l+r)%2==0?(l+r)/2:((l+r)/2)+1;
         /*   if((l+r)%2==0) {
                 m = (l + r) / 2;
            }else{
                m = ((l + r) / 2) +1;
            }*/
            if (A[m] > X) {
                r = m - 1;
            } else {
                    l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}

