package com.mtb.practise;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {
        Map<String,String> languages=new HashMap<>();

        if(!languages.containsKey("Java")) {
            languages.put("Java","A complied high level,object-oriented,platform independent language");
            System.out.println("This course add successfully in map");
        }else{

            System.out.println("This course already exists in map");
        }

        languages.put("Python","An interpreted,object oriented, high level programming language with dynamic semantics");
        languages.put("Algol","An algorithmic  language");
        System.out.println(languages.put("BASIC","Beginners All purposes symbolic instruction code"));
        System.out.println(languages.put("Lisp","Therein lies madness"));

        if(!languages.containsKey("Java")) {
            System.out.println(languages.put("Java", "This course is about Java"));
        }else{
            System.out.println("This course already exists in map");
        }
        System.out.println(languages.get("Java"));

        System.out.println("======================================================");

//        languages.remove("Lisp");
        if(languages.remove("Algol","An algorithmic  language")){
            System.out.println("Algol removed");
        }else{
            System.out.println("Algol not removed,key/value pair not found");
        }

   //     System.out.println(languages.replace("Lisp","a functional programming language with imperative features."));
        System.out.println(languages.replace("Scala","this will not be added"));

        if(languages.replace("Lisp","This will not replace","a functional programming language with imperative features.")){
            System.out.println("Lisp was replaced");
        }else{
            System.out.println("Lisp was not replaced");
        }

        for (String key:languages.keySet()) {
            System.out.println(key+" : "+languages.get(key));
        }


     }
}
