package com.mtb.ex.mapflatmap;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author MithileshB
 * @created 03/12/2021 - 7:36 AM
 * @project interviewex
 */
public class Main {
    public static void main(String[] args) {
        List<String> cities=new ArrayList<>();
        cities.add("Nagpur");
        cities.add("Pune");
        cities.add("Mumbai");
        Employee e1=new Employee(5,"Mithilesh",cities);
        List<String> cities1=new ArrayList<>();
        cities1.add("Nagpur");
        cities1.add("Pune");
        cities1.add("Banglore");
        Employee e2=new Employee(2,"Priya",cities1);
        List<String> cities2=new ArrayList<>();
        cities2.add("Nagpur");
        cities2.add("Noida");
        cities2.add("Pune");
        cities2.add("Mumbai");
        Employee e3=new Employee(1,"Shubhangi",cities2);

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        getEmployeesInSort(employeeList);
        //System.out.println(employeeList);
/*
        List<Integer> employeeId = employeeList.stream()
                .map(employee -> employee.getId())
                .collect(Collectors.toList());
        List<List<String>> citiesWorkedIn = employeeList.stream()
                .map(employee -> employee.getCitiesWorkedIn())
                .collect(Collectors.toList());
        Set<String> citiesWorkedInList = employeeList.stream().flatMap(employee -> employee.getCitiesWorkedIn().stream()).collect(Collectors.toSet());
        System.out.println(employeeId);
        System.out.println(citiesWorkedIn);
        System.out.println(citiesWorkedInList);


        */
        /*map(Function);
        filter(Predicate)
                forEach(Consumer)

                collect(Supplier)
                reduce(BinaryOperator)*/

        employeeList.sort(Comparator.comparing(Employee::getName).reversed());

        System.out.println("EmployeesList");
        employeeList.forEach(employee -> System.out.println(employee.getName()+"-"+employee.getCitiesWorkedIn()));

        Comparator<Employee> groupByComparator=Comparator.comparing(Employee::getName).thenComparing(Employee::getId);
        System.out.println("GroupBy comparator");
        employeeList.sort(groupByComparator);
        employeeList.forEach(employee -> System.out.println(employee.getName()+"-"+employee.getId()+"-"+employee.getCitiesWorkedIn()));
        //System.out.println(employeeList);
   //     employeeList.stream().map(employee -> employee.setName("M"))
    }

    private static void getEmployeesInSort(List<Employee> employeeList) {
        System.out.println("Start of getEmployeesInSort");
        Collections.sort(employeeList,(e1,e2)->e1.getId()-e2.getId());
        Collections.sort(employeeList,Comparator.comparingInt(Employee::getId));
        Collections.sort(employeeList,(e1,e2)->e1.getName().compareTo(e2.getName()));
        Collections.sort(employeeList, Comparator.comparing(Employee::getName));

        System.out.println(employeeList);
        System.out.println("End of getEmployeesInSort");
    }
}
