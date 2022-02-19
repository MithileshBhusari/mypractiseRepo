package com.mtb.ex;

import java.util.function.Function;

/**
 * @author MithileshB
 * @created 29/01/2022 - 12:56 PM
 * @project interviewex
 */
public class TestFunction {

    public static void main(String[] args){
        String[] bws={"1","Gbps"};

        Function<String[],Integer> bwVal=(bwArr)->{
            if(bwArr[1].contains("Gbps")){
                return Integer.parseInt(bwArr[0])*1000;
            }else{
                return Integer.parseInt(bwArr[0]);
            }
        };
        System.out.println(bwVal.apply(bws));
    }
}
