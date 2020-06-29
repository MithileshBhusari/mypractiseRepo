package com.mtb.designpatter.liskovsubstitutionprinciple;

import java.util.Map;

/**
 * @author MithileshB
 * @created 15/06/2020 - 9:57 AM
 * @project DesignPattern
 */
public interface ICoffeeMachine {
    CoffeeDrink brewCoffee(CoffeeSelection selection);
}

class BasicCoffeeMachine implements ICoffeeMachine{

    private Map<CoffeeSelection, Configuration> configMap;
    private Map<CoffeeSelection,GroundCoffee> groundCoffee;
    private BrewingUnit brewingUnit;

    @Override
    public CoffeeDrink brewCoffee(CoffeeSelection selection) {
        return null;
    }
}

class PremiumCoffeeMachine implements ICoffeeMachine{

    @Override
    public CoffeeDrink brewCoffee(CoffeeSelection selection) {
        return null;
    }
}

class CoffeeDrink{

}

enum CoffeeSelection{
    ESPRESSO,FILTER_COFFEE,BASIC_COFFEE;
}

class Configuration{

}