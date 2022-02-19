package com.mtb.ex.java8;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;
/**
 * @author MithileshB
 * @created 23/01/2022 - 11:34 PM
 * @project interviewex
 */
public class Java8Map {
    public static void main(String [] args){
        Integer[] intArray={1,2,3,4,5,6,7,8,9,10,9,4,2};
        List<Integer> listOfInteger=new ArrayList<>(Arrays.asList(intArray));

        Set<Integer> set=new HashSet<>();

        set.addAll(listOfInteger);
       /* List<Integer> collect2 = listOfInteger.stream()
                .map(duplicateElement)
                .collect(Collectors.toList());*/
        System.out.println("duplz");
        List<Integer> doubled=new ArrayList<>();
        for(int i=0;i<listOfInteger.size();i++){
            Integer result=listOfInteger.get(i)*2;
            doubled.add(result);
        }

        Function<Integer,Integer> timesTwo=x->x*2;
        List<Integer> collect = listOfInteger.stream()
                .map(timesTwo)
                .collect(Collectors.toList());

        Predicate<Integer> predicateFunct= x->x%2==0;
        List<Integer> collect1=listOfInteger.stream()
                .filter(predicateFunct)
                .collect(Collectors.toList());
        System.out.println(collect1);

        String[] wordsArr={"Hello" ,"Mithilesh","How","are","your","preparation","going","on"};
        List<String> wordsList=new ArrayList<>(Arrays.asList(wordsArr));

        Function<Integer,Predicate<String>> createLengthTest=(minLength)->{
            return (str)->str.length()>minLength;
        };
        Predicate<String> isLongerThan3=createLengthTest.apply(3);
        List<String> listWithLengthGT5=wordsList.stream()
                .filter(isLongerThan3)
                .collect(Collectors.toList());
        System.out.println(listWithLengthGT5);

        /*********Reduce Example*********/
        BinaryOperator<Integer> getsum=(acc,x)->{
            Integer result=acc+x;
            System.out.println("acc: "+acc+" ,x: "+x+",result:"+result);
            return result;
        };
    /*    Integer sum = listOfInteger.stream()
                .reduce(0, getsum);
        System.out.println(sum);
*/
        /******.collect() methods predefined functions***/
        Set<String> SetWithLengthGT5=wordsList.stream()
                .filter(isLongerThan3)
                .collect(Collectors.toSet());
        System.out.println(SetWithLengthGT5);

            String str=wordsList.stream()
                    .filter(isLongerThan3)
                    .collect(Collectors.joining(","));
        System.out.println(str);

        Long howManyLongWords=wordsList.stream()
                .filter(isLongerThan3)
                .collect(Collectors.counting());
        System.out.println(howManyLongWords);

        Map<Integer, List<String>> wordLengthMap = wordsList.stream()
                .filter(isLongerThan3)
                .collect(Collectors.groupingBy(
                        words -> words.length()
                ));
        System.out.println(wordLengthMap);


        Map<Boolean, List<String>> wordLengthMapPartition = wordsList.stream()
                .filter(isLongerThan3)
                .collect(Collectors.partitioningBy(
                        words -> words.length()>5
                ));
        System.out.println(wordLengthMapPartition);
    }
}
