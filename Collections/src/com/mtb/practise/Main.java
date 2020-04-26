package com.mtb.practise;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre=new Theatre("Sudama",8,12);

        List<Theatre.Seat> seatCopy=new ArrayList<>(theatre.seats);
        printList(seatCopy);
    }

    public static void printList(List<Theatre.Seat> seatList){
        for(Theatre.Seat seat:seatList){
            System.out.print(" "+seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("===========================================================================");
    }
}
