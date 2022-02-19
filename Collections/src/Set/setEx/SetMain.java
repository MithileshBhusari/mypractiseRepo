package Set.setEx;

import com.sun.xml.internal.ws.api.client.WSPortInfo;

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

    private static Map<HeavenlyBody.Key,HeavenlyBody> solarSystem=new HashMap<>();
    private static Set<HeavenlyBody> planets=new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp=new Planet("Mercury",88);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp=new Planet("Venus ",225);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp=new Planet("Earth",365);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp=new Planet("Mars",687);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);


        HeavenlyBody tempMoon= new Moon("Moon",27);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon= new Moon("Deimos",1.3);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon= new Moon("Phobos",0.3);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp=new Planet("Jupitor",4332);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon= new Moon("Io",1.8);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon= new Moon("Europa",3.5);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon= new Moon("Ganynede",7.1);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp=new Planet("Saturn",10759);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon= new Moon("Callisto",16.7);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp=new Planet("Uranus",30660);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp=new Planet("Neptune",165);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp=new Planet("Pluto",248);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        System.out.println("Planets");
        for(HeavenlyBody planet:planets){
            System.out.println("\t"+planet.getKey());
        }

        HeavenlyBody heavenlyBody=solarSystem.get(HeavenlyBody.makeKey("Mars",HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of "+heavenlyBody.getKey());
        for (HeavenlyBody jupitorMoon:heavenlyBody.getSatellites()) {
            System.out.println("\t" + jupitorMoon.getKey());
        }

        Set<HeavenlyBody> moons=new HashSet<>();
        for (HeavenlyBody planet:planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons");
        for (HeavenlyBody moon:moons){
            System.out.println("\t"+moon.getKey());
        }

        HeavenlyBody pluto=new DwarfPlanet("Pluto",842);
        planets.add(pluto);

        System.out.println("All Planets");
        for(HeavenlyBody planet:planets){
            System.out.println(planet);
            //System.out.println("\t"+planet.getKey()+": "+planet.getOrbitalPeriod());
        }

        HeavenlyBody earth1=new Planet("Earth",365);
        HeavenlyBody earth2=new Planet("Earth",365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(pluto.equals(earth1));
        System.out.println(earth1.equals(pluto));


        solarSystem.put(pluto.getKey(),pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));

        System.out.println();
        System.out.println("The Solar systems contains:");
        for(HeavenlyBody heavenlyBody1:solarSystem.values()){
            System.out.println(heavenlyBody1);
        }

    }

}
