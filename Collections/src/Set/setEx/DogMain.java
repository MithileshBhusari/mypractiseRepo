package Set.setEx;

/**
 * @author MithileshB
 * @created 02/06/2020 - 9:43 AM
 * @project mypractiseRepo
 */
public class DogMain {

    public static void main(String[] args) {
        Labrador rover=new Labrador("Rover");
        Dog rover2=new Dog("Rover");

        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
    }
}
