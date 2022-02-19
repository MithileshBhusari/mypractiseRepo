
import java.io.*;
import java.util.*;

/**
 * @author MithileshB
 * @created 28/01/2021 - 9:09 AM
 * @project GFG30dayscodingChallenge
 */
public class Day3Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            long array[] = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextLong();
            }
            Solution ob = new Solution();
            System.out.println(ob.smallestpositive(array, n));
            t--;
        }
    }
// } Driver Code Ends


//User function Template for Java

    static class Solution {
        long smallestpositive(long[] array, int n) {
            // Your code goes here
            Arrays.sort(array);
            if(array.length==1){
                return array[0]+1;
            }
            if(!(array[0]+array[1]==array[0]+1)){
                return array[0]+1;
            }
            long counter=array[0]+1;
            for(int i=0;i<array.length-1;i++){
                long sum=array[i];
                for(int j=i+1;j<array.length;j++) {
                    if(counter==array[j]){
                        counter++;
                    }
                    sum=sum+array[j];
                    if (!(array[i] + array[j] == counter)) {
                        continue;
                    }else{
                        counter++;
                    }
                    if(sum==counter){
                        counter++;
                    }
                }
            }
            for(int i=array.length-1;i>0;i--){
                long sum=array[i];
                for(int j=array.length-2;j>=0;j--){
                    sum=sum+array[j];
                    if(sum==counter){
                        counter++;
                 }
                }
            }
            return counter;
        }
    }
}