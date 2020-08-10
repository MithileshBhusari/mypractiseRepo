package com.mtb.decoratorex;

import com.mtb.decoratorex.readLearncode.LogMessage;

/**
 * @author MithileshB
 * @created 22/07/2020 - 9:44 AM
 * @project DesignPattern
 */
@ComplexMessage
public class SystemMessage implements LogMessage {
    @Override
    public void printMessage() {

    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public void setMessage(String message) {

    }
}
