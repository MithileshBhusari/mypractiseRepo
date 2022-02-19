import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author MithileshB
 * @created 02/04/2021 - 10:01 AM
 * @project GFG30dayscodingChallenge
 */
public class FirstEquilibriumPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            FirstEquilibriumPoint firstEquilibriumPoint = new FirstEquilibriumPoint();

            System.out.println(firstEquilibriumPoint.equilibriumPoint(arr, n));

        }
    }

    private int equilibriumPoint(long[] arr, int n) {
        int leftsum = 0;
        int sum = 0;

        for (int i = 0; i < n; ++i) {
            sum +=arr[i];
        }

        for (int i = 0; i < n; ++i) {
            sum -= arr[i];
            if (leftsum == sum) {
                return i+1;
            }
            leftsum += arr[i];
        }
        return -1;
    }
}
