package map.Adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {

        /*Change the program to allow players to type full words,or phrases then move to the
        * current location based upon their input.
        * The player should be able to type commands such as "Go West", "run South" of just "East"
        * and the program will move to the appropriate location if there is one. As at present,
        * an attempt to move in an invalid direction should print a message and remain in the same place.
        *
        * Single letter commands (N,S,E,W,Q)  should still be available.*/

        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> tempExits=new HashMap<String,Integer>();
        locations.put(0, new Location(0, "You are sitting in front of computer learning java",null));

        tempExits=new HashMap<String,Integer>();
        tempExits.put("W",2);
        tempExits.put("N", 5);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        locations.put(1, new Location(1, "You are standing at the end of the road.",tempExits));

        tempExits=new HashMap<String,Integer>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at top of hill",tempExits));

        tempExits=new HashMap<String,Integer>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building",tempExits));

        tempExits=new HashMap<String,Integer>();
        tempExits.put("W", 2);
        tempExits.put("N", 1);
        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExits));

        tempExits=new HashMap<String,Integer>();
        tempExits.put("W", 2);
        tempExits.put("S", 1);
        locations.put(5, new Location(5, "You are in the forest",tempExits));
        Map<String,String> vocabulary=new HashMap<>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("EAST","E");
        vocabulary.put("NORTH","N");
        vocabulary.put("WEST","W");
        vocabulary.put("SOUTH","S");
        int loc = 1;
        while (true) {
                System.out.println(locations.get(loc).getDescription());
                tempExits.remove("S");
                if (loc == 0) {
                    break;
                }

                Map<String, Integer> exits = locations.get(loc).getExits();
                System.out.print("Available exits are:");
                for (String exit : exits.keySet()) {
                    System.out.print(exit + ", ");
                }
                System.out.println();

                String direction = scanner.nextLine().toUpperCase();
                if(direction.length()>1){
                    String[] words=direction.split(" ");
                    for (String word:words){
                        if(vocabulary.containsKey(word)){
                            direction=vocabulary.get(word);
                            break;
                        }
                    }
                }
                if (exits.containsKey(direction)) {
                    loc = exits.get(direction);
                } else {
                    System.out.println("You can not go in that direction");
                }
            }
    }
}
