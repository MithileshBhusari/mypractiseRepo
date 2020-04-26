package com.mtb.practise;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre=new Theatre("Sudama",8,12);

        if(theatre.reserveSeat("D12")){
            System.out.println("Please pay for D12");
        }else{
            System.out.println("Seat already reserved");
        }

        if(theatre.reserveSeat("F13")){
            System.out.println("Please pay for F13");
        }else{
            System.out.println("Seat already reserved");
        }


        if(theatre.reserveSeat("D07")){
            System.out.println("Please pay for D07");
        }else{
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reverseList=new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseList);
        printList(reverseList);

        List<Theatre.Seat> priceSeats=new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00",13.00));
        priceSeats.add(theatre.new Seat("A00",13.00));

        Collections.sort(priceSeats,Theatre.PRICE_ORDER);
        printList(priceSeats);

    }

    public static void printList(List<Theatre.Seat> seatList){
        for(Theatre.Seat seat:seatList){
            System.out.print(" "+seat.getSeatNumber()+" "+seat.getPrice());
        }
        System.out.println();
        System.out.println("===========================================================================");
    }


}
