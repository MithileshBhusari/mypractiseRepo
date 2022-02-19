import java.util.Scanner;

/**
 * @author MithileshB
 * @created 29/01/2021 - 8:54 PM
 * @project GFG30dayscodingChallenge
 */
public class Day4Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n, k, ans;
            n = scanner.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            k = scanner.nextInt();

            Day4Solution obj = new Day4Solution();
            ans = obj.find_min(a, n, k);
            System.out.println(ans);
            t--;
        }
    }

    private int find_min(int[] a, int n, int k) {
        int result = -1;
        int possible_picks = 0;
        int definatePicks = 0;
        for (int i : a) {
            possible_picks += i / 2;
            if (i % 2 == 0) {
                definatePicks += (i - 2) / 2;
            } else {
                definatePicks += (i - 1) / 2;
            }
        }
        if (possible_picks < k) {
            return result;
        }
        if (k <= definatePicks) {
            result = (2 * (k - 1) + n + 1);
        } else {
            result = (2 * definatePicks + (k - definatePicks) + n);
        }
        return result;


    }
}
