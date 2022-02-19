package com.mtb.ex;

import javax.management.StandardEmitterMBean;

/**
 * @author MithileshB
 * @created 05/12/2021 - 7:11 AM
 * @project interviewex
 */
public class RotateArray {

    public static void main(String[] args) {
            int arr[]={1,2,3,4,5,};
          //  int arr[]= {2,4,6,8,10,12,14,16,18,20};
            int d=3;
            //int d=2;
            int N=arr.length;
          rotateArr(arr,d,N);
            //rotateArrEfficient(arr,d,N);
      //  leftRotate(arr,d,N);
        printArray(arr,N);
    }

    private static void rotateArr(int[] arr, int d, int N) {


        for(int i=d;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        for(int i=0;i<d;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void rotateArrEfficient(int arr[],int d,int n){

        //To Handle if d>=n
        d=d%n;
        int i,j,k,temp;
        int g_c_d=gcd(d,n);

        for(i=0;i<g_c_d;i++){
            temp=arr[i];
            j=i;
            while(true){
                k=j+d;
                if(k>=n)
                    k=k-n;
                if(k==i)
                    break;
                arr[j]=arr[k];
                j=k;
            }
            arr[j]=temp;
        }
    }

    private static void leftRotate(int arr[],int d,int n){
        d=d%n;
        int gcd_v=gcd(d,n);
        for(int i=0;i<gcd_v;i++){
            int temp=arr[i];
            int j=i;
            while(true){
                int k=j+d;
                if(k>=n)
                    k=k-n;
                if(k==i)
                    break;
                arr[j]=arr[k];
                j=k;
            }
            arr[j]=temp;
        }
    }
    private static void printArray(int arr[],int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int gcd(int d, int n) {
        if(n==0)
            return d;
        else
            return gcd(n,d%n);
    }
}
