package com.mtb.designpatter.dependencyinversionprinciple;

import org.javatuples.Triplet;

import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author MithileshB
 * @created 12/06/2020 - 12:58 PM
 * @project DesignPattern
 */
public enum Relationship {
    PARENT,
    CHILD,
    SIBLING
}

class Person{
    public String name;

    public Person(String name){
        this.name=name;
    }
}

interface  RelationshipBrowser{
    List<Person> finaAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser{  //low-level module
    private List<Triplet<Person,Relationship,Person>> relations=new ArrayList<>();
/*

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }
*/

    public void addParentAndChild(Person parent, Person child){
        relations.add(new Triplet<>(parent,Relationship.PARENT,child));
        relations.add(new Triplet<>(parent,Relationship.CHILD,parent));
    }

    @Override
    public List<Person> finaAllChildrenOf(String personName) {
        return relations.stream()
        .filter(x-> Objects.equals(x.getValue0().name,personName)
        && x.getValue1()==Relationship.PARENT)
        .map(Triplet::getValue2)
        .collect(Collectors.toList());
    }
}


class Research{  // high-level module
/*    public Research(Relationships relationships){
        List<Triplet<Person,Relationship,Person>> relations=relationships.getRelations();
        relations.stream()
                .filter(x->x.getValue0().name.equals("Tejrao")
                && x.getValue1()== Relationship.PARENT)
                .forEach(ch-> System.out.println("Tejrao has a child called : "+ch.getValue2().name));
    }*/

    public Research(RelationshipBrowser  browser){
        List<Person> children=browser.finaAllChildrenOf("Tejrao");
        for (Person child:children) {
            System.out.println("Tejrao has a child called  "+child.name);
        }
    }
}

class Demo{
    public static void main(String[] args) {
        Person parent = new Person("Tejrao");
        Person child1 = new Person("Mithilesh");
        Person child2=new Person("Priya");
        Person child3=new Person("Mamta");
        Person child4=new Person("Shubhangi");

        Relationships relationships=new Relationships();
        relationships.addParentAndChild(parent,child1);
        relationships.addParentAndChild(parent,child2);
        relationships.addParentAndChild(parent,child3);
        relationships.addParentAndChild(parent,child4);

        new Research(relationships);

    }
}