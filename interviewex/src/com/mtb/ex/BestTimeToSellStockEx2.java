package com.mtb.ex;

/**
 * @author MithileshB
 * @created 09/02/2022 - 12:41 AM
 * @project interviewex
 */
public class BestTimeToSellStockEx2 {
    public static int maxProfit(int[] prices){

        int min_val=Integer.MAX_VALUE;
        int max_profit=0;
        int temp=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min_val){
                min_val=prices[i];
            }else if(prices[i]-min_val>temp){
                temp=prices[i]-min_val;
            }
        }
        return max_profit;
    }

    public static int maxProfitforAllDays(int[] arr){
        int maxProfit=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                maxProfit+=(arr[i]-arr[i-1]);
            }
        }
        return maxProfit;
    }

    public static int max2TransactionProfit(int[] arr){
        int maxProfit=0;
        int minValue=Integer.MAX_VALUE;
        int tempProfit=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                tempProfit+=(arr[i]-arr[i-1]);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfitforAllDays(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfitforAllDays(new int[]{3,3,5,0,0,3,1,4}));
    }
}
