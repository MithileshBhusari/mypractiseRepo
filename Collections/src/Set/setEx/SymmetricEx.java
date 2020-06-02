package Set.setEx;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author MithileshB
 * @created 02/06/2020 - 10:04 AM
 * @project mypractiseRepo
 */
public class SymmetricEx {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }
        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union container " + union.size() + " elements.");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        for (int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "once upon a time , The king of russia decided to hold a grandfist";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for (String s : words) {
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "the"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);

        diff1.removeAll(divine);
        printSet(diff1);


        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest=new HashSet<>(nature);
        unionTest.addAll(divine);

        System.out.println("Intersection");
        Set<String> intersectionTest=new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        printSet(intersectionTest);

        System.out.println("Symmetric Difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if(nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }

        if(divine.containsAll(intersectionTest)){
            System.out.println("Intersection is subset of divine");
        }

        if(nature.containsAll(intersectionTest)){
            System.out.println("Intersection is subset of nature");
        }

    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
