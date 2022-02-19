import jdk.nashorn.internal.ir.CallNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author MithileshB
 * @created 02/04/2021 - 3:43 PM
 * @project GFG30dayscodingChallenge
 */
public class SortAnArrayOf012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < n; i++) {
                stringBuffer.append(arr[i] + " ");
            }
            System.out.println(stringBuffer);
        }

    }

    private static void sort012(int[] a, int n) {
        int low = 0;
        int high = n - 1;
        int mid = 0;
        int temp;
        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    temp = a[low];
                    a[low] = a[mid];
                    a[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                   high--;
                    break;
            }
        }
    }
}
