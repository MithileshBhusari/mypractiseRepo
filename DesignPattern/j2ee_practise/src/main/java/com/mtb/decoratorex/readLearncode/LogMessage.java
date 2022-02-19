package com.mtb.decoratorex.readLearncode;

/**
 * @author MithileshB
 * @created 22/07/2020 - 9:25 AM
 * @project DesignPattern
 */
public interface LogMessage {
    void printMessage();
    String getMessage();
    void setMessage(String message);
}
