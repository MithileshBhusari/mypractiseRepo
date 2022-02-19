package com.mtb.ex.java8;
import java.util.function.BiFunction;
import java.util.function.Function;
/**
 * @author MithileshB
 * @created 23/01/2022 - 11:20 PM
 * @project interviewex
 */
public class JavaBiFunctionalInterfaceEx {


        protected static class MyMath{
            public static Integer add(Integer x,Integer y){
                return x+y;
            }
            public static Integer subtract(Integer x,Integer y){
                return x-y;
            }
            public static Integer combine2And3(BiFunction<Integer,Integer,Integer> combineFunc){
                return combineFunc.apply(2,3);
            }
            public static Integer timesTwo(Integer x){
                return x*2;
            }
            public static Integer timesThree(Integer x){
                return x*3;
            }
            public static Integer timesFour(Integer x) {
                return x * 4;
            }
            public static Function<Integer,Integer> createMultiplier(Integer y){
                return (Integer x)->x*y;
            }
        }
        public static void main(String[] args){
            System.out.println(MyMath.combine2And3(MyMath::add));
            System.out.println(MyMath.combine2And3(MyMath::subtract));
            System.out.println(MyMath.combine2And3((x,y)->2*x+2*y));
  /*  NoArgsFunction
            System.out.println(MyMath.createMultiplier(3).apply(4));
            NoArgFunctio<String> greeter=createGreeter.apply();
            System.out.println(greeter.apply());
*/
            BiFunction<Float,Float,Float> divide=(x,y)->x/y;

            Function<BiFunction<Float,Float,Float>,BiFunction<Float,Float,Float>> secondArgIsntZeroCheck=
                    (func) ->(x,y) -> {
                        if(y==0f){
                            return 0f;
                        }
                        return func.apply(x,y);
                    };

            BiFunction<Float,Float,Float> divideSafe=secondArgIsntZeroCheck.apply(divide);
            System.out.println(divideSafe.apply(25f,5f));

        }
}
