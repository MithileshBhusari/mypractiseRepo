package com.mtb.practise;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {
        Map<String,String> languages=new HashMap<>();
        languages.put("Java","A complied high level,object-oriented,platform independent language");
        languages.put("Python","An interpreted,object oriented, high level programming language with dynamic semantics");
        languages.put("Algol","An algorithmic  language");
        System.out.println(languages.put("BASIC","Beginners All purposes symbolic instruction code"));
        System.out.println(languages.put("Lisp","Therein lies madness"));

        System.out.println(languages.get("Java"));
        System.out.println(languages.put("Java","This course is about Java"));
        System.out.println(languages.get("Java"));

    }
}
