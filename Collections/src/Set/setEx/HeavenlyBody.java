package Set.setEx;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MithileshB
 * @created 01/06/2020 - 10:14 AM
 * @project mypractiseRepo
 */
public class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyTypes;
    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTERIOD
    }
    public HeavenlyBody(String name, double orbitalPeriod,BodyTypes bodyTypes) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyTypes=bodyTypes;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyTypes getBodyTypes() {
        return bodyTypes;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody) {
            HeavenlyBody heavenlyBody = (HeavenlyBody) obj;
            if (this.name.equals(heavenlyBody.getName())) {
                return this.bodyTypes == heavenlyBody.getBodyTypes();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        System.out.println("Hashcode called");
        return this.name.hashCode() + 57+this.bodyTypes.hashCode();
    }

    @Override
    public String  toString() {
        return
                name + " , " +
                        bodyTypes+
                        " , " + orbitalPeriod ;
    }
}
