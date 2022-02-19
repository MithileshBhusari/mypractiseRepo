package com.mtb.ex;

import java.util.HashSet;

/**
 * @author MithileshB
 * @created 03/02/2022 - 6:46 PM
 * @project interviewex
 */
public class UniqueuEmailsEx {

    public static int uniqueEmails(String[] emails){
        HashSet<String> unique_emails=new HashSet<>();
        for(String email:emails){
            int split_position=email.indexOf("@");
            String local_name=email.substring(0,split_position);
            String domain_name=email.substring(split_position);
            if(local_name.contains("+")){
                int plus_position=local_name.indexOf("+");
                local_name=local_name.substring(0,plus_position);
            }
            local_name=local_name.replaceAll("\\.","");
            unique_emails.add(local_name+domain_name);
        }
        return unique_emails.size();
    }

    public static void main(String[] args){
        String[] arr={"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(uniqueEmails(arr));
    }
}
