package com.mtb.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre=new Theatre("Sudama",8,12);

        List<Theatre.Seat> seatCopy=new ArrayList<>(theatre.seats);
        printList(seatCopy);
        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")){
            System.out.println("Please pay for A02");
        }else{
            System.out.println("Seat already reserved");
        }

        Collections.reverse(seatCopy);
        System.out.println("Printing Seatcopy  using Collections.reverse() method");
        printList(seatCopy);
        System.out.println("Printing theatre.seats");
        printList(theatre.seats);


        Collections.shuffle(seatCopy);
        System.out.println("Printing Seatcopy  using Collections.shuffle() method");
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
