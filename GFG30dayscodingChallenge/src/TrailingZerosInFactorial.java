import java.util.Scanner;

/**
 * @author MithileshB
 * @created 29/03/2021 - 1:53 PM
 * @project GFG30dayscodingChallenge
 */
public class TrailingZerosInFactorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            TrailingZerosInFactorial trailingZerosInFactorial=new TrailingZerosInFactorial();
            int ans=trailingZerosInFactorial.trailingZeros(n);
            System.out.println(ans);
        }
    }

    private int trailingZeros(int n) {
        int f=5;
        int result=0;
        while((n/f)>0){
            result+=(n/f);
            f*=5;
        }
        return result;
    }
}
