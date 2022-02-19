package com.mtb.ex;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author MithileshB
 * @created 02/02/2022 - 12:10 AM
 * @project interviewex
 */
public class SpiralMatrix {

 public static void main(String[] args){
     Scanner sc=new Scanner(System.in);

     int t=sc.nextInt();
     while(t-->0){
            int r=sc.nextInt();
            int c=sc.nextInt();

            int matrix[][]=new int[r][c];

            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    matrix[i][j]=sc.nextInt();
                }
            }
         ArrayList<Integer> ans=spiralOrder(matrix,r,c);
            ans.stream().forEach(i->System.out.print(i+" "));
     }


 }

    private static ArrayList<Integer> spiralOrder(int[][] matrix, int r, int c) {
     ArrayList<Integer> res=new ArrayList<>();

     if(matrix.length==0){
         return res;
     }
     int rowBegin=0;
     int rowEnd=matrix.length-1;
     int columnBegin=0;
     int columnEnd=matrix[0].length-1;
     while(rowBegin<=rowEnd && columnBegin<=columnEnd){
         for(int i=columnBegin;i<=columnEnd;i++){
             res.add(matrix[rowBegin][i]);
         }
         rowBegin++;
         for(int i=rowBegin;i<=rowEnd;i++){
             res.add(matrix[i][columnEnd]);
         }
         columnEnd--;
         if(rowBegin<=rowEnd){
             for(int i=columnEnd;i>=columnBegin;i--){
                 res.add(matrix[rowEnd][i]);
             }
         }
         rowEnd--;
         if(columnBegin<=columnEnd){
             for(int i=rowEnd;i>=rowBegin;i--){
                 res.add(matrix[i][columnBegin]);
             }
         }
         columnBegin++;
     }
     return res;
    }

}
