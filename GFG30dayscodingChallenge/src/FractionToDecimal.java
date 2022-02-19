
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MithileshB
 * @created 29/03/2021 - 2:01 PM
 * @project GFG30dayscodingChallenge
 */
public class FractionToDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        while(t-->0){
            String[] s=bufferedReader.readLine().trim().split(" ");
            int numerator = Integer.parseInt(s[0]);
            int denominator=Integer.parseInt(s[1]);
            FractionToDecimal fractionToDecimal=new FractionToDecimal();
            String ans=fractionToDecimal.fractionToDecimalFun(numerator,denominator);
            System.out.println(ans);

        }
    }

    private String fractionToDecimalFun(int numerator, int denominator) {
        StringBuilder result=new StringBuilder();
        int quotient=numerator/denominator;
        int remainder=numerator%denominator;
        result.append(quotient);

        if(remainder==0){
            return result.toString();
        }else{
            result.append(".");
            Map<Integer,Integer> map=new HashMap<Integer,Integer>();
            while (remainder!=0){
                if(map.containsKey(remainder)){
                    int length=map.get(remainder);
                    result.insert(length,"(");
                    result.append(")");
                    break;
                }else{
                    map.put(remainder,result.length());
                    remainder*=10;
                    quotient=remainder/denominator;
                    remainder=remainder%denominator;
                    result.append(quotient);
                }
            }
        }
        return result.toString();
    }
}
