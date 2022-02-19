import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author MithileshB
 * @created 28/01/2021 - 10:34 AM
 * @project GFG30dayscodingChallenge
 */
public class Day3Solution1 {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            long array[] = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextLong();
            }
            Day3Solution1.Solution ob = new Day3Solution1.Solution();
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
            long smallestPI=1;

            for(int i=0;i<array.length;i++){
              if(array[i]<=smallestPI){
                  smallestPI=smallestPI+array[i];
              }else{
                  break;
              }
            }
            return smallestPI;
    }
}
}
