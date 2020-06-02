package Set.setEx;

import java.util.Objects;

/**
 * @author MithileshB
 * @created 02/06/2020 - 9:39 AM
 * @project mypractiseRepo
 */
public class Labrador extends Dog {

    public Labrador(String name){
        super(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof Labrador){
            String objectName=((Labrador) o).getName();
            return this.getName().equals(objectName);
        }
        return false;
 //       if (o == null || getClass() != o.getClass()) return false;
       // Labrador labrador = (Labrador) o;
    //    return Objects.equals(this.getName(), labrador.getName());
    }

}
