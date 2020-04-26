package com.mtb.practise;

public class Main {

    public static void main(String[] args) {
        Theatre theatre=new Theatre("Sudama",8,12);
     //   theatre.getSeats();

        if(theatre.reserveSeat("H10")){
            System.out.println("Please pay");
        }else {
            System.out.println("Sorry, seat is taken");
        }

        if(theatre.reserveSeat("H10")){
            System.out.println("Please pay");
        }else {
            System.out.println("Sorry, seat is taken");
        }
    }
}
