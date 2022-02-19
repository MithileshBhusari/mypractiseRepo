package com.mtb.ex.java8;

/**
 * @author MithileshB
 * @created 19/02/2022 - 6:50 AM
 * @project interviewex
 */
/***
 * These are similar to default methods,just that it is static hence its implementation
 *can not be changed in child classes.
 *Thus implementing class need not and can not change the defination .
 * Means Static method of interface can not be overridden
 *
 * Similar to static methods ,these should also be called through interface name.
 *i.e. : Interface.StaticMethodName
 *
 * Why Do we really need static method in interfaces?
 * 1)Interface static method helps us in providing security by not allowing implementation classes to override them.
 *2)Interface static methods are good for providing utility methods,for example null checking i.e. whose definatiion
 * never change.
 *
 * */

interface AquaticAnimal{
    static public void livesIn(){
        System.out.println("Lives in water");
    }
}
interface TerrestrialAnimal{
    default public void livesIn(){
        System.out.println("Lives on land");
    }
}
interface Animal{

}
public class StaticClassDemo implements Animal,AquaticAnimal,TerrestrialAnimal{

    @Override
    public void livesIn() {
        AquaticAnimal.livesIn();
    }
}
