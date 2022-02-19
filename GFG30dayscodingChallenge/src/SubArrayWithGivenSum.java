import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author MithileshB
 * @created 02/04/2021 - 11:51 AM
 * @project GFG30dayscodingChallenge
 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int s=sc.nextInt();

            int[] m=new int[n];
            for(int j=0;j<n;j++){
                m[j]=sc.nextInt();
            }
            ArrayList<Integer> res=subArraySum(m,n,s);
            for(int k=0;k<res.size();k++){
                System.out.print(res.get(k)+" ");
            }
            System.out.println();
        }
    }

    private static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
            int sum=arr[0];
            int counter=0;
            ArrayList<Integer> resultList=new ArrayList<>();
            resultList.add(-1);
            for(int i=1;i<=n;i++){
                while(sum>s && counter<i-1){
                    sum=sum-arr[counter];
                    counter++;
                }
                if(sum==s){
                    resultList.removeIf(Objects::nonNull);
                    resultList.add(counter+1);
                    resultList.add(i);
                    return resultList;
                }
                if(i<n){
                    sum+=arr[i];
                }
            }
            return resultList;
    }
}
