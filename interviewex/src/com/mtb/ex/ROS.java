package com.mtb.ex;

import java.sql.PseudoColumnUsage;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author MithileshB
 * @created 25/01/2022 - 2:45 AM
 * @project interviewex
 */
public class ROS {
    public static String reorganizeString(String s){
        Map<Character,Integer> counts=new HashMap<>();
        for(char c:s.toCharArray()){
            counts.put(c,counts.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> queue=new PriorityQueue<>((a,b)->counts.get(b)-counts.get(a));
        queue.addAll(counts.keySet());

        StringBuilder result=new StringBuilder();

        while(queue.size()>1){
            char current=queue.remove();
            char next=queue.remove();
            result.append(current);
            result.append(next);
            counts.put(current,counts.get(current)-1);
            counts.put(next,counts.get(next)-1);
            if(counts.get(current)>0){
                queue.add(current);
            }
            if(counts.get(next)>0){
                queue.add(next);
            }
        }
        if(!queue.isEmpty()){
            char last=queue.remove();
            if(counts.get(last)>1){
                return "";
            }
            result.append(last);
        }
        return result.toString();
    }

    public static String reorg(String s){
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        PriorityQueue<Character> queue=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));

        queue.addAll(map.keySet());
        StringBuilder result=new StringBuilder();
        while(queue.size()>1){
            char first = queue.remove();
            char next=queue.remove();
            result.append(first);
            result.append(next);
            map.put(first,map.get(first)-1);
            map.put(next,map.get(next)-1);
            if(map.get(first)>0){
                queue.add(first);
            }
            if(map.get(next)>0){
                queue.add(next);
            }
        }
        if(!queue.isEmpty()){
            char last=queue.remove();
            if(map.get(last)>1){
                return "";
            }
            result.append(last);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(reorg("aaabb"));
    }
}
