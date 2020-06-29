package com.mtb.designpatter.singleResponsibilityPrinciple;

/**
 * @author MithileshB
 * @created 15/06/2020 - 9:50 AM
 * @project DesignPattern
 */
public class UserSettingService {

    public void changeEmail(User user){
        if(checkAccess(user)){
            //grant option to change
        }
    }

    public boolean checkAccess(User user){
        //verify if the user is valid
    }
}
