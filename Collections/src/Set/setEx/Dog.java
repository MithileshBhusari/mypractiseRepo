package Set.setEx;

import java.util.Objects;

/**
 * @author MithileshB
 * @created 02/06/2020 - 9:35 AM
 * @project mypractiseRepo
 */
public class Dog {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof Dog){
            String objectName=((Dog) o).getName();
            return this.getName().equals(objectName);
        }
        return false;
    /*    if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name);*/
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
