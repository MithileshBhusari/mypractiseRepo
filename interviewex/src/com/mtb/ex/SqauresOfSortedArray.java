package com.mtb.ex;

/**
 * @author MithileshB
 * @created 11/01/2022 - 11:09 PM
 * @project interviewex
 */
public class SqauresOfSortedArray {
        public static int[] sortedSquares(int[] nums){
            int len=nums.length;
            int pPointer=0;
            while(pPointer<len && nums[pPointer]<0){
                pPointer+=1;
            }
            int nPointer=pPointer-1;

            int[] sorted_squares=new int[len];
            int counter=0;
            while(nPointer>=0 && pPointer<len){
                int pPSquare=nums[pPointer]*nums[pPointer];
                int nPSquare=nums[nPointer]*nums[nPointer];

                if(nPSquare<pPSquare){
                    sorted_squares[counter]=nPSquare;
                    nPointer-=1;
                }else{
                    sorted_squares[counter]=pPSquare;
                    pPointer+=1;
                }
                counter+=1;
            }
            while(nPointer>=0){
                sorted_squares[counter]=nums[nPointer]*nums[nPointer];
                nPointer-=1;
                counter+=1;
            }
            while(pPointer<len){
                sorted_squares[counter]=nums[pPointer]*nums[pPointer];
                pPointer+=1;
                counter+=1;
            }

            return sorted_squares;
        }

        public static void main(String[] args){
            int[] A={-4,-1,0,3,9};
            int []B=sortedSquares(A);
            for(int i:B){
                System.out.print(i+" ");
            }
        }
}
