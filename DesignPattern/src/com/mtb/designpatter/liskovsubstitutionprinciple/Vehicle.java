package com.mtb.designpatter.liskovsubstitutionprinciple;

/**
 * @author MithileshB
 * @created 15/06/2020 - 10:12 AM
 * @project DesignPattern
 */
public interface Vehicle {

    public int getSpeed();
    public int getCubicCapacity();
}

class Car implements  Vehicle{


    @Override
    public int getSpeed() {
        return 50;
    }

    @Override
    public int getCubicCapacity() {
        return 5;
    }

    public boolean isHatchBack(){
        return true;
    }
}

class Bus implements  Vehicle{

    @Override
    public int getSpeed() {
        return 60;
    }

    @Override
    public int getCubicCapacity() {
        return 30;
    }

    public String getEmergencyExitLoc(){
        return "25";
    }
}

class VehicleDemo{
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle car = new Car();

        System.out.println(bus.getE);
        System.out.println(car.);
    }
}