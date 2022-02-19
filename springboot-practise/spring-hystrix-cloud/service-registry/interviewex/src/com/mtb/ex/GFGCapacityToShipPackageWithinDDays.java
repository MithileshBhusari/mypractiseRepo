package com.mtb.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author MithileshB
 * @created 30/01/2022 - 3:39 PM
 * @project interviewex
 */
public class GFGCapacityToShipPackageWithinDDays {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int N=Integer.parseInt(br.readLine());
            String s[]=br.readLine().split(" ");
            int []arr=new int[N];
            int D=Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(s[i]);
            }
            System.out.println(leastWeightCapacity(arr,N,D));
        }
    }

    private static int leastWeightCapacity(int[] wt, int n, int d) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < wt.length; i++) {
            sum += wt[i];
            max = Math.max(max, wt[i]);
        }

        int low = max;
        int high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(wt, mid, d)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] wt, int mid, int actualDays) {
        int requiredDays=1;
        int sum=0;
        for(int i=0;i<wt.length;i++){
            sum+=wt[i];
            if(sum>mid){
                requiredDays++;
                sum=wt[i];
            }
        }
        return requiredDays<=actualDays;
    }

}
