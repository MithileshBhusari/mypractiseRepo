package com.mtb.ex;

import java.util.PriorityQueue;

/**
 * @author MithileshB
 * @created 26/12/2021 - 8:48 AM
 * @project interviewex
 */

public class KClosestPoints {

   static class Pair implements Comparable<Pair>{

        int first,second;
        Pair(int a,int b){
            first=a;
            second=b;
        }

        public int compareTo(Pair o){
            int x1=first*first;
            int y1=second*second;
            int x2=o.first*o.first;
            int y2=o.second*o.second;
            return (x1+y1)-(x2+y2);
        }
    }
    static void clsoestPoints(int x[],int y[],int n,int k){
        PriorityQueue<Pair> pq=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(new Pair(x[i],y[i]));
        }
        for(int i=0;i<k;i++){
            Pair p=pq.poll();

            System.out.println(p.first+" "+p.second);
        }
    }

    public static void main(String[] args){
        int x[]={1,-2};
        int y[]={3,2};
        int k=1;
        int n=x.length;
        clsoestPoints(x,y,n,k);
    }
}
