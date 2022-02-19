package com.mtb.ex;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author MithileshB
 * @created 02/12/2021 - 8:15 AM
 * @project interviewex
 */
public class PriorityQueueEx {
    public static void main(String[] args) {
        PriorityQueue<String> pq=new PriorityQueue<>();

        pq.add("Mithilesh");
        pq.add("Tejrao");
        pq.add("Vrunda");
        pq.add("Bhusari");

        Iterator<String> iterator = pq.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }
}
