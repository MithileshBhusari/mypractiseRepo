package com.mtb.ex;

import java.util.Arrays;

/**
 * @author MithileshB
 * @created 08/02/2022 - 5:30 PM
 * @project interviewex
 */
public class SumOfEvenNumberAfterQueries {
    public  static int[] sumEvenNumberAfterQueries(int[] A,int[][] queries){
        int[] output_arr=new int[queries.length];
        int even_sum=0;

        for(int val:A){
            if(val%2==0){
                even_sum+=val;
            }
        }
        for(int i=0;i<queries.length;i++){
            int index=queries[i][1];
            int value=queries[i][0];
            if(A[index]%2==0) {
                even_sum -= A[index];
            }
            A[index]+=value;
            if(A[index]%2==0){
                even_sum+=A[index];
            }
            output_arr[i]=even_sum;
        }
        return output_arr;
    }

    public static void main(String[] args) {
        int[] result=sumEvenNumberAfterQueries(new int[]{1,2,3,4},new int[][]{{1,0},{-3,1},{-4,0},{2,3}});
    for(int i:result){
        System.out.print(i+" ");
    }
    }
}
