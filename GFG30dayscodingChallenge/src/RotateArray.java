import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author MithileshB
 * @created 02/04/2021 - 7:10 PM
 * @project GFG30dayscodingChallenge
 */
public class RotateArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int d=Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            rotate(arr,n,d);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < n; i++) {
                stringBuffer.append(arr[i] + " ");
            }
            System.out.println(stringBuffer);
        }
    }

    private static void rotate(int[] arr, int n,int d) {
        int gcd=gcdOfTwoNumbers(d,n);
        for(int i=0;i<gcd;i++){
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

    private static int gcdOfTwoNumbers(int d, int n) {
        if(n==0)
            return d;
        else
            return gcdOfTwoNumbers(n,d%n);
    }

}