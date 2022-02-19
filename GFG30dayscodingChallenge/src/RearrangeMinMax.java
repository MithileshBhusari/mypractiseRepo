import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author MithileshB
 * @created 02/04/2021 - 4:20 PM
 * @project GFG30dayscodingChallenge
 */
public class RearrangeMinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            rearrange(arr,n);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < n; i++) {
                stringBuffer.append(arr[i] + " ");
            }
            System.out.println(stringBuffer);
        }
    }

    private static void rearrange(int[] arr, int n) {

    }

}