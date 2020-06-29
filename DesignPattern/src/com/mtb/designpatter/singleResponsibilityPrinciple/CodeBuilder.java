package com.mtb.designpatter.singleResponsibilityPrinciple;

/**
 * @author MithileshB
 * @created 13/06/2020 - 8:04 PM
 * @project DesignPattern
 */
public class CodeBuilder {
    Person p;
    public CodeBuilder(String className){
        p=new Person();
    }
}

class Person{
    public String name;
    public int age;

    public Person(){
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
