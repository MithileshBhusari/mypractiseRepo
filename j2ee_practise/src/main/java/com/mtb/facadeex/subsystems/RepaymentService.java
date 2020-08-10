package com.mtb.facadeex.subsystems;

import com.mtb.facadeex.Customer;

import javax.ejb.Stateless;

/**
 * @author MithileshB
 * @created 19/07/2020 - 8:38 PM
 * @project DesignPattern
 */
@Stateless
public class RepaymentService {
    public void setupPaymentSchedule(Customer customer,Double principle,Integer months){
        //setup monthly automatic payment from customer account to bank

    }
}
