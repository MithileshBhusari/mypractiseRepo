package com.mtb.ex;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MithileshB
 * @created 03/02/2022 - 7:24 PM
 * @project interviewex
 */
public class MorseCodeEx {
    public static void main(String[] args){
        String[] MORSE_CODE=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        //System.out.println(a(MORSE_CODE));
        System.out.println(uniqueMorseRepresentation(MORSE_CODE));
    }
    public static int uniqueMorseRepresentation(String [] words){

        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        Set<String> uniqueCodes=new HashSet<>();
        for(String word:words){
            StringBuilder transformation=new StringBuilder();
            for(char c:word.toCharArray()){
                transformation.append(MORSE[c - 'a']);
            }
            uniqueCodes.add(transformation.toString());
        }
        return uniqueCodes.size();
    }
    public static int a(String[] words){

        String arr[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        String stbr, wrd = "";

        for(int i=0;i<words.length;i++){
            wrd = words[i];
            char c[] = wrd.toCharArray();
            stbr = "";
            for(int j=0;j<c.length;j++){
                stbr = stbr + (arr[c[j]-'a']);
            }
            set.add(stbr);
        }
        return set.size();
    }
}
