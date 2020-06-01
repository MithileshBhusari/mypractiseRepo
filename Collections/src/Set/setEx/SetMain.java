package Set.setEx;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author MithileshB
 * @created 01/06/2020 - 10:21 AM
 * @project mypractiseRepo
 */
public class SetMain {

    private static Map<String,HeavenlyBody> solarSystem=new HashMap<>();
    private static Set<HeavenlyBody> planets=new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp=new HeavenlyBody("Mercury",88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp=new HeavenlyBody("Venus ",225);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp=new HeavenlyBody("Earth",365);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp=new HeavenlyBody("Mars",687);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);


        HeavenlyBody tempMoon= new HeavenlyBody("Moon",27);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        tempMoon= new HeavenlyBody("Deimos",1.3);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        tempMoon= new HeavenlyBody("Phobos",0.3);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        temp=new HeavenlyBody("Jupitor",4332);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        tempMoon= new HeavenlyBody("Io",1.8);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        tempMoon= new HeavenlyBody("Europa",3.5);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        tempMoon= new HeavenlyBody("Ganynede",7.1);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        temp=new HeavenlyBody("Saturn",10759);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        tempMoon= new HeavenlyBody("Callisto",16.7);
        solarSystem.put(tempMoon.getName(),tempMoon);
        temp.addMoon(tempMoon);

        temp=new HeavenlyBody("Uranus",30660);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp=new HeavenlyBody("Neptune",165);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        temp=new HeavenlyBody("Pluto",248);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        System.out.println("Planets");
        for(HeavenlyBody planet:planets){
            System.out.println("\t"+planet.getName());
        }

        HeavenlyBody heavenlyBody=solarSystem.get("Saturn");
        System.out.println("Moons of "+heavenlyBody.getName());
        for (HeavenlyBody jupitorMoon:heavenlyBody.getSatellites()) {
            System.out.println("\t" + jupitorMoon.getName());
        }

        Set<HeavenlyBody> moons=new HashSet<>();
        for (HeavenlyBody planet:planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons");
        for (HeavenlyBody moon:moons){
            System.out.println("\t"+moon.getName());
        }
    }

}
