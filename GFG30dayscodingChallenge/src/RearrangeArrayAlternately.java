import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author MithileshB
 * @created 02/04/2021 - 5:42 PM
 * @project GFG30dayscodingChallenge
 */
public class RearrangeArrayAlternately {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bufferedReader.readLine().trim());
        while (t-->0){
            int n=Integer.parseInt(bufferedReader.readLine().trim());
            int arr[]=new int[n];
            String[] inputArr = bufferedReader.readLine().trim().split(" ");
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(inputArr[i]);
            }
            rearrange(arr,n);
            StringBuffer stringBuffer=new StringBuffer();
            for(int i=0;i<n;i++){
                stringBuffer.append(arr[i]+" ");
            }
            System.out.println(stringBuffer);
        }

    }

    private static void rearrange(int[] arr, int n) {
            int min=0;
            int max=n-1;
            int max_element=arr[n-1]+1;

            for(int i=0;i<n;i++){
                if(i%2==0){
                    arr[i]=arr[i]+(arr[max]%max_element)*max_element;
                    max--;
                }else{
                    arr[i]=arr[i]+(arr[min]%max_element)*max_element;
                    min++;
                }
            }

            for(int i=0;i<n;i++){
                arr[i]=arr[i]/max_element;
            }
    }
}
