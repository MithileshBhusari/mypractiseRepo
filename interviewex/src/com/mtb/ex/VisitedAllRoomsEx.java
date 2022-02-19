package com.mtb.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author MithileshB
 * @created 11/01/2022 - 10:23 PM
 * @project interviewex
 */
public class VisitedAllRoomsEx {
        public static boolean canVisitAllRooms(List<List<Integer>> rooms){
            boolean[] seen=new boolean[rooms.size()];
            seen[0]=true;
            Stack<Integer> keys=new Stack();
            keys.add(0);
            while(!keys.isEmpty()){
                int current_key=keys.pop();
                for(int new_key:rooms.get(current_key)){
                    if(!seen[new_key]){
                        seen[new_key]=true;
                        keys.add(new_key);
                    }
                }
            }
            for(boolean visited:seen){
                if(!visited){
                    return false;
                }
            }
            return true;
        }


        public static void main(String[] args){
            List<List<Integer>> list=new ArrayList<>(Arrays.asList(Arrays.asList(1),Arrays.asList(2),Arrays.asList(3),Arrays.asList()));

            System.out.println(canVisitAllRooms(list));
        }
}
