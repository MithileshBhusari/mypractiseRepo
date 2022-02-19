package com.mtb.ex;

/**
 * @author MithileshB
 * @created 06/12/2021 - 7:19 AM
 * @project interviewex
 */
public class MisplacedIndex {
    void rearrange(int arr[], int n) {

        int misplacedIndex = -1;

        for (int i = 0; i < n; i++)
        {
            if (misplacedIndex >= 0)
            {
                if (((arr[i] >= 0) && (arr[misplacedIndex] < 0)) || ((arr[i] < 0) && (arr[misplacedIndex] >= 0))) {
                    rightrotate(arr, n, misplacedIndex, i);
                    if (i - misplacedIndex >= 2)
                        misplacedIndex = misplacedIndex + 2;
                    else
                        misplacedIndex = -1;
                }
            }
            // if no entry has been flagged out-of-place
            if (misplacedIndex == -1)
            {
                // check if current entry is out-of-place
                if (((arr[i] >= 0)
                        && ((i %2) == 1))
                        || ((arr[i] < 0)
                        && (i % 2) == 0))
                    misplacedIndex = i;
            }
        }
    }
    void rightrotate(int arr[], int n, int misplacedIndex,
                     int cur)
    {
        int tmp = arr[cur];
        for (int i = cur; i > misplacedIndex; i--)
            arr[i] = arr[i - 1];
        arr[misplacedIndex] = tmp;
    }

    void printArray(int arr[], int n)
    {
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }


    public static void main(String[] args) throws Exception {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
*/
        int arr[]={9, 4, -2, -1, 5, 0, -5, -3, 2};
        int n=9;
            new MisplacedIndex().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

}
