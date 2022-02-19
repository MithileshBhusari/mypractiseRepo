import java.util.Scanner;

/**
 * @author MithileshB
 * @created 30/01/2021 - 11:46 PM
 * @project GFG30dayscodingChallenge
 */
public class Day5Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            Day5Solution day5Solution = new Day5Solution();
            System.out.println(day5Solution.findK(a, n, m, k));
            t--;
        }

    }


    public int findK(int[][] a, int n, int m, int k) {
        if (k > m * n) {
            return -1;
        }
        int count = 0;
        return addElementsInArray(a, 0, 0, n, m, k, count);
    }

    private int addElementsInArray(int[][] a, int i, int j, int n, int m, int k, int count) {

        if (i >= n || j >= m) {
            return -1;
        }


        for (int p = i; p < m; p++) {
            count++;
            if (count == k) {
                return a[i][p];
            }
        }
        for (int p = i + 1; p < n; p++) {
            count++;
            if (count == k) {
                return a[p][m - 1];
            }

        }

        if ((n - 1) != i) {
            for (int p = m - 2; p >= j; p--) {
                count++;
                if (count == k) {
                    return a[n - 1][p];
                }
            }
        }
        if ((m - 1) != j) {
            for (int p = n - 2; p > i; p--) {
                count++;
                if (count == k) {
                    return a[p][j];
                }
            }
        }
        return addElementsInArray(a, i + 1, j + 1, n - 1, m - 1, k, count);
    }
}
