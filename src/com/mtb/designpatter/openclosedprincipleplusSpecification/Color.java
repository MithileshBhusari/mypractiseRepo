package com.mtb.designpatter.openclosedprincipleplusSpecification;

import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author MithileshB
 * @created 12/06/2020 - 11:30 AM
 * @project DesignPattern
 */
public enum Color {
    RED,GREEN,BLUE
}

enum Size{
    SMALL,MEDIUM,LARGE,HUGE
}

class Product{
    private String name;
    private Color color;
    private Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }
}

class ProductFilter{
    public Stream<Product> filterByColor(List<Product> products,Color color){
        return products.stream().filter(p->p.getColor()==color);
    }
    public Stream<Product> filterBySize(List<Product> products,Size size){
        return products.stream().filter(p->p.getSize()==size);
    }

    public Stream<Product> filterByColorAndSize(List<Product> products,Color color,Size size){
        return  products.stream().filter(p->p.getColor()==color && p.getSize()==size);
    }
}

interface  Specification<T>{
    boolean isSatisfied(T item);
}

interface Filter<T>{
    Stream<T> filter(List<T > items,Specification<T> specification);
}

class ColorSpecification implements Specification<Product>{

    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return  item.getColor()==color;
    }
}

class SizeSpecification implements  Specification<Product>{

    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getSize()==size;
    }
}

class BetterFilter implements  Filter<Product>{

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
        return items.stream().filter(p->specification.isSatisfied(p));
    }
}

class AndSpecification implements Specification<Product>{
    private Specification<Product> first,second;
    public AndSpecification(Specification<Product> first,Specification<Product> second){
        this.first=first;
        this.second=second;
    }
    @Override
    public boolean isSatisfied(Product item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}
class Demo{
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products= Arrays.asList(apple, tree,house);

        ProductFilter productFilter = new ProductFilter();
        System.out.println("Green Products (old) :");

        productFilter.filterByColor(products,Color.GREEN)
        .forEach(p-> System.out.println(" - "+p.getName()+" is green"));

        BetterFilter betterFilter = new BetterFilter();
        System.out.println("Green Products (new) :");
        betterFilter.filter(products,new ColorSpecification(Color.GREEN))
        .forEach(p-> System.out.println(" - "+p.getName()+" is green"));

        System.out.println("Large Blue Items: ");
        betterFilter.filter(products,new AndSpecification(new ColorSpecification(Color.BLUE),
                new SizeSpecification(Size.LARGE)))
        .forEach(p-> System.out.println(" - "+p.getName()+" is Blue and Large"));
    }
}