package com.mtb.ex.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author MithileshB
 * @created 24/01/2022 - 12:29 AM
 * @project interviewex
 */
public class Chapter3Challenge1 {
    static class Person{
        public final String name;
        public final Integer age;
        public Person(String name,Integer age){
            this.name=name;
            this.age=age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
    static class Car{
        public final String make;
        public final String color;
        public final Float price;
        public Car(String make,String color,Float price){
            this.make=make;
            this.color=color;
            this.price=price;
        }

        public String getMake() {
            return make;
        }

        public String getColor() {
            return color;
        }

        public Float getPrice() {
            return price;
        }
    }


    static class Employee{
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name,Integer age,String jobTitle,Float salary){
            this.name=name;
            this.age=age;
            this.jobTitle=jobTitle;
            this.salary=salary;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public Float getSalary() {
            return salary;
        }
    }

    public static void main(String[] args){
        Employee[] empArr={new Employee("Mithilesh",28,"Developer",40f),
                new Employee("Dhruv",28,"Developer",36f),
                new Employee("Priya",32,"DevopsEng",36f),
                new Employee("Rama",30,"Tester",10f),
                new Employee("Ajay",25,"Developer",8f)};

        List<Employee> employeeList=new ArrayList<>(Arrays.asList(empArr));

        BinaryOperator<Float> salarySum= (acc,x)->{
            Float result=acc+x;
          //  System.out.println("acc: "+acc+",x: "+x+",result:"+result);
            return result;
        };

        Map<String, List<Employee>> employeesByJobTitle = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.jobTitle));
        System.out.println(employeesByJobTitle);

        Function<Employee,Float> empSalary=e->e.salary;
        BinaryOperator<Float> salaryAverage= Float::sum;
        Map<String, Float> collect1 = employeesByJobTitle.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(empSalary)
                                .reduce(0f, salaryAverage) / entry.getValue().size()));

        System.out.println(collect1);
        Map<String,Float> averageSalariesMap=employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.jobTitle))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                                        entry->entry.getKey(),
                                        entry->entry.getValue().stream()
                                            .map(employee -> employee.salary)
                                            .reduce(0f,(acc,x)->acc+x)/entry.getValue().size()));
        System.out.println(averageSalariesMap);



        Float empSalarySum = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(0f, salarySum);
  //      System.out.println("salary sum:"+empSalarySum);
        Person[] personArr={new Person("Shubhangi",36),
                new Person("Mamta",35),
                new Person("Priya",32),
                new Person("Mithilesh",28),
                new Person("Tejrao",62),
                new Person("Vrunda",62)};




        List<Person> personList=new ArrayList<>(Arrays.asList(personArr));
        List<String> personNameList = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
 //       System.out.println(personNameList);

        Car[] carsArr={new Car("Chev","red",45000f),
                new Car("Ford","blue",23000f),
                new Car("Toyoto","grey",14000f),
                new Car("Lamborghini","white",150000f),
                new Car("Renault","blue",150000f),
                new Car("Hyundai","blue",15000f),
                new Car("Maruti","blue",10000f)
        };
        List<Car> list=new ArrayList<>(Arrays.asList(carsArr));

        Predicate<Car> isCarBlue=car->car.getColor().equalsIgnoreCase("blue");
        List<Car> blueCars = list.stream()
                .filter(isCarBlue)
                .collect(Collectors.toList());
   //     blueCars.forEach(car->System.out.println(car.getMake()));
        //System.out.println(blueCars);


    }
}
