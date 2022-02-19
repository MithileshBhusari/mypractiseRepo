package Set.setEx;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author MithileshB
 * @created 01/06/2020 - 10:14 AM
 * @project mypractiseRepo
 */
public class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTERIOD
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyTypes) {
        this.key = new Key(name, bodyTypes);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public Key getKey() {
        return key;
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody) {
            HeavenlyBody heavenlyBody = (HeavenlyBody) obj;
            return this.key.equals(heavenlyBody.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return
                this.key.name + " , " +
                        this.key.bodyTypes +
                        " , " + orbitalPeriod;
    }

    public static final class Key {

        private String name;
        private BodyTypes bodyTypes;

        private Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyTypes = bodyTypes;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(name, key.name) &&
                    bodyTypes == key.bodyTypes;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyTypes.hashCode();
        }

        @Override
        public String toString() {
            return
                    this.name + " , " + this.bodyTypes;
        }
    }
}
