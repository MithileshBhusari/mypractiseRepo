package com.mtb.ex.javaeightpractise;
import com.mtb.ex.mapflatmap.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author MithileshB
 * @created 17/01/2022 - 1:06 AM
 * @project interviewex
 */
public class FlatMapEx {
    public static void main(String[] args){
   /*     Map<String,List<String>> people=new HashMap<>();
        people.put("John",Arrays.asList("1","1"));
        people.put("Mary",Arrays.asList("2","3"));
        people.put("Jenny",Arrays.asList("4","5"));
        people.put("Jack",Arrays.asList("6","7"));

        List<String> phones=people.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
         List<Stream<String>>phones1=people.values().stream().map(Collection::stream)
                //.map(Collection::stream)
                .collect(Collectors.toList());
        for(String phone:phones){
            System.out.print(phone+" ");
        }

        System.out.println("**************");
        List<Integer> list=Arrays.asList(10,29,30,20,40,40,20,10,3,94,4);
        Set<Integer> set=new HashSet<>();
        list.stream().filter(x->!set.add(x)).collect(Collectors.toSet())
                .forEach(x->System.out.println(x));

        System.out.println("************************");
        list.stream().skip(6).forEach(System.out::println);

        System.out.println("************************");*/

        String str="welcome to code decode and code decode welcome you";
        List<char[]> characterList=Arrays.asList(str.toCharArray());
        char[] charArr=str.toCharArray();
        Stream<Character> cStream= IntStream.range(0,charArr.length).mapToObj(i->charArr[i]);
        Map<Character, Long> collect = cStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
      /*  characterList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<String> list1=Arrays.asList(str.split(" "));

        Map<String,Long> map=list1.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);*/


    }
}
