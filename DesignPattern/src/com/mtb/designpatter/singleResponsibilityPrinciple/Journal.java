package com.mtb.designpatter.singleResponsibilityPrinciple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MithileshB
 * @created 12/06/2020 - 10:58 AM
 * @project DesignPattern
 */
public class Journal {

    private final List<String> entries=new ArrayList<>();
    private static int count=0;

    public void addEntry(String text){
        entries.add(""+(++count)+": "+text);
    }

    public void removeEntry(int index){
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(),entries);
    }

    public void save(String fileName) throws FileNotFoundException{
        try(PrintStream out=new PrintStream(fileName)){
            out.println(toString());
        }
    }

    public void load(String fileName){}
    public void load(URL url){}
}

/**Separation of concern*/
class Persistence{
    public void saveToFile(Journal journal,
                           String fileName,
                           boolean overwrite) throws FileNotFoundException {
        if(overwrite || new File(fileName).exists()){
            try(PrintStream out=new PrintStream(fileName)){
                    out.println(journal.toString());
            }
        }
    }

//    public Journal load(String fileName){}
//    public Journal load(URL url){}
}


class Demo{

    public static void main(String[] args) throws IOException {
        Journal j=new Journal();
        j.addEntry("I am happy");
        j.addEntry("I did good breakfast");
        System.out.println(j);

        Persistence p=new Persistence();
        String fileName="c:\\temp\\journal.txt";
        p.saveToFile(j,fileName,true);

        Runtime.getRuntime().exec("notepad.exe "+fileName);
    }
}
