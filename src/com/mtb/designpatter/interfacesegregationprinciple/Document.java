package com.mtb.designpatter.interfacesegregationprinciple;

import javax.print.Doc;
import java.io.PrintStream;
import java.util.Map;

/**
 * @author MithileshB
 * @created 12/06/2020 - 12:43 PM
 * @project DesignPattern
 */
public class Document {
}


interface Machine{
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

class MultiFunctionPrinter implements Machine{

    @Override
    public void print(Document d) {

    }

    @Override
    public void fax(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface Printer{
    void print(Document d);
}

interface Scanner{
    void scan(Document d);
}

//YAGNI =  You Ain't Going to Need it

class JustAPrinter implements Printer{

    @Override
    public void print(Document d) {

    }
}

class Photocopier implements  Printer,Scanner{

    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface MultifunctionDevice extends Printer,Scanner{}