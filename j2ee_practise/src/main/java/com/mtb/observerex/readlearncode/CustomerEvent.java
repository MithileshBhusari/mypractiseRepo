package com.mtb.observerex.readlearncode;

import javax.inject.Qualifier;
import java.lang.annotation.*;

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
