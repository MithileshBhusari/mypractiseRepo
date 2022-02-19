package com.mtb.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author MithileshB
 * @created 30/01/2022 - 1:50 PM
 * @project interviewex
 */
public class GFGHandshakeWays {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int N=Integer.parseInt(br.readLine());
            System.out.println(count(N));
        }

    }

    private static int count(int n) {

        HashMap<Integer,Integer> map=new HashMap<>();
        if(n%2==1){
            return 0;
        }
        if(n==0){
            return 1;
        }
        int sum=0;
        for(int i=0;i<n;i+=2){
            sum+=(count(i)*count(n-2-i));
            }
        return sum;
        }
}
