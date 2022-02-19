import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


/**
 * @author MithileshB
 * @created 28/03/2021 - 7:06 PM
 * @project GFG30dayscodingChallenge
 */
public class MissingNumberInArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i <n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            MissingNumberInArray missingNumberInArray = new MissingNumberInArray();
            System.out.println(missingNumberInArray.MissingNumber(array, n));
        }
    }

    private int MissingNumber(int[] array, int n) {
        int xor1=array[0];
        for(int i=1;i< array.length;i++){
            xor1=xor1^array[i];
        }
        int xor2=1;
        for(int i=2;i<=(array.length+1);i++){
            xor2=xor2^i;
        }
        return (xor1^xor2);
    }

}
