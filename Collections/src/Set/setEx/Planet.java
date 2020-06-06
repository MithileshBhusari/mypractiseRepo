package Set.setEx;

/**
 * @author MithileshB
 * @created 06/06/2020 - 7:42 PM
 * @project mypractiseRepo
 */
public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
            if(moon.getBodyTypes()==BodyTypes.PLANET){
                return super.addSatellite(moon);
            }else{
                return false;
            }
    }
}
