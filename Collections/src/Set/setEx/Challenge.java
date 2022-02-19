package Set.setEx;

/**
 * @author MithileshB
 * @created 01/06/2020 - 11:31 AM
 * @project mypractiseRepo
 */
public class Challenge {

    /**
     * When overriding the equals() method in the HeavenlyBody class,we were careful
     * to make sure that it would not return true if  a HeavenlyBody was compared to subclass
     * itself.
     * We did that to demonstrate that method,but it was actually unnecessary in
     * HeavenlyBody class.
     *
     * The minichallenge is just a question:why was it necessary?
     *
     * Answer:The HeavenlyBody class is declared final,so it can not be subclassed.
     * The java string class is also final which is why it can safely use the instanceOf
     * method without having to worry about the comparision with a subclass.
     * */
}
