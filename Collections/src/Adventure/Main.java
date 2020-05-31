package Adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer,Location> locations=new HashMap<Integer,Location>();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        locations.put(0,new Location(0,"You are sitting in front of computer learning java"));
        locations.put(1,new Location(1,"You are standing at the end of the road."));
        locations.put(2,new Location(2,"You are at top of hill"));
        locations.put(3,new Location(3,"You are inside a building"));
        locations.put(4,new Location(4,"You are in a valley beside a stream"));
        locations.put(5,new Location(5,"You are in the forest"));

        int loc=1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc==0){
                break;
            }
            loc=scanner.nextInt();
            if(!locations.containsKey(loc)){
                System.out.println("You can not go in that direction");
            }
        }
    }
}
