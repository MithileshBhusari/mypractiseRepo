package com.mtb.ex;

import java.util.PriorityQueue;

/**
 * @author MithileshB
 * @created 26/12/2021 - 8:00 AM
 * @project interviewex
 */
public class ClosestFromOrigin {

    public static void main(String[] args) {
        int points[][]={{3,3},{5,-1},{-2,4},{6,-2}};
        int k=2;
        int[][] a=pClosest(points,k);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(" "+a[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] pClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->
                (b[0]*b[0] +b[1]*b[1]) -
                        (a[0]*a[0]+a[1]*a[1]));

        for(int[] point:points){
            maxHeap.add(point);
            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }
        int[][] result=new int[k][2];
        while(k-->0){
            result[k]=maxHeap.remove();
        }
        return result;
    }
}
