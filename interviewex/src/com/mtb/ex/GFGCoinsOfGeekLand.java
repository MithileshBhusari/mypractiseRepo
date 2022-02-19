package com.mtb.ex;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author MithileshB
 * @created 30/01/2022 - 12:38 PM
 * @project interviewex
 */
public class GFGCoinsOfGeekLand {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.next());
        while(t-->0){
            int n=Integer.parseInt(sc.next());
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=Integer.parseInt(sc.next());
                }
            }
            int k=Integer.parseInt(sc.next());
            GFGCoinsOfGeekLand gfgCoinsOfGeekLand=new GFGCoinsOfGeekLand();
            System.out.println(gfgCoinsOfGeekLand.Maximum_sum(a,n,k));
        }

    }

    private int Maximum_sum(int[][] a, int n, int k) {

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                    if(i-1>=0)
                        a[i][j]+=a[i-1][j];
                    if(j-1>=0)
                        a[i][j]+=a[i][j-1];
                if(i-1>=0 && j-1>=0)
                    a[i][j]-=a[i-1][j-1];
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int temp=a[i][j];
                if(i-k>=0)
                temp-=a[i-k][j];
                if(j-k>=0)
                temp-=a[i][j-k];
                if(i-k>=0 && j-k>=0)
                temp+=a[i-k][j-k];
                ans=Math.max(ans,temp);
            }
        }
        return ans;
    }
}
