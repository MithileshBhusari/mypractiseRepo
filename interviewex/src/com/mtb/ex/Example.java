package com.mtb.ex;

import jdk.nashorn.internal.objects.annotations.Function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MithileshB
 * @created 22/01/2022 - 11:09 AM
 * @project interviewex
 */
public class Example {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(21);
        list.add(21);
        list.add(20);

        list.stream()
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("To Print Odd numbers \n");
        list.stream().filter(val->val%2!=0).forEach(System.out::println);

    }


}
