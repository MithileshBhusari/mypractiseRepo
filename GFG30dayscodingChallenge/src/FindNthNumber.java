import java.util.Scanner;

/**
 * @author MithileshB
 * @created 29/03/2021 - 4:19 PM
 * @project GFG30dayscodingChallenge
 */
public class FindNthNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            long n=sc.nextLong();
            FindNthNumber findNthNumber=new FindNthNumber();
            long k=findNthNumber.findNth(n);
            System.out.println(k);
        }
    }

    private long findNth(long n) {
        long p=1;
        long result=0;

        while(n>0){
            result+=p*(n%9);
            n/=9;
            p*=10;
        }
        return result;
    }
}
