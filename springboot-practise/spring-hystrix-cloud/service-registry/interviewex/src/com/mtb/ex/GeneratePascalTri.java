package com.mtb.ex;

import java.sql.SQLOutput;
import java.util.List;
import java.util.ArrayList;
/**
 * @author MithileshB
 * @created 30/12/2021 - 8:27 PM
 * @project interviewex
 */
public class GeneratePascalTri {
    public static void main(String[] args){

        List<List<Integer>> generatedTriangle=generatePascalTriangle(5);

        for(List<Integer> integerList:generatedTriangle){
            for(Integer i:integerList){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> generatePascalTriangle(int numRows){

        List<List<Integer>> triangle=new ArrayList<>();
        if(numRows==0)
            return triangle;

        List<Integer> first_row=new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        for(int i=1;i<numRows;i++){
            List<Integer> prev_row=triangle.get(i-1);
            List<Integer> row=new ArrayList<>();
            row.add(1);

            for(int j=1;j<i;j++){
                row.add(prev_row.get(j-1)+prev_row.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
