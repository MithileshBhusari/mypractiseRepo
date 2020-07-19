package mtb.observerex.readlearncode;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author MithileshB
 * @created 19/07/2020 - 9:50 PM
 * @project DesignPattern
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface CustomerEvent {
    Type value();

    enum Type {ADD,REMOVE}
}
