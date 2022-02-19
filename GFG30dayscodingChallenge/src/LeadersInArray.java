import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author MithileshB
 * @created 02/04/2021 - 11:23 AM
 * @project GFG30dayscodingChallenge
 */
public class LeadersInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n=Integer.parseInt(br.readLine().trim());
            int arr[]=new int[n];
            String[] inputLine = br.readLine().trim().split(" ");

            for(int i=0;i<n;i++){
                 arr[i] = Integer.parseInt(inputLine[i]);
            }

            StringBuffer stringBuffer=new StringBuffer();
            List<Integer> res=new ArrayList<>();
            res=leaders(arr,n);
            for(int i=0;i<res.size();i++){
                stringBuffer.append(res.get(i)+" ");
            }
            System.out.println(res);
        }
    }

    private static List<Integer> leaders(int[] arr, int n) {
        int mfr=arr[n-1];
        List<Integer> result=new ArrayList<>();
        result.add(mfr);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>mfr){
                mfr=arr[i];
                result.add(mfr);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
