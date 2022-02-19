package com.mtb.ex.mapflatmap;

import java.util.List;

/**
 * @author MithileshB
 * @created 03/12/2021 - 7:34 AM
 * @project interviewex
 */
public class Employee {
    private int id;
    private String name;
    private List<String> citiesWorkedIn;

    public Employee(int id, String name, List<String> citiesWorkedIn) {
        this.id = id;
        this.name = name;
        this.citiesWorkedIn = citiesWorkedIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCitiesWorkedIn() {
        return citiesWorkedIn;
    }

    public void setCitiesWorkedIn(List<String> citiesWorkedIn) {
        this.citiesWorkedIn = citiesWorkedIn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", citiesWorkedIn=" + citiesWorkedIn +
                '}';
    }
}
