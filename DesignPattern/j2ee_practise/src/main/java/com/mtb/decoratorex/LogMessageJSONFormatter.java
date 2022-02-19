package com.mtb.decoratorex;

import com.mtb.decoratorex.readLearncode.LogMessage;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.time.LocalDate;

/**
 * @author MithileshB
 * @created 22/07/2020 - 9:31 AM
 * @project DesignPattern
 */
@Priority(20)
@Decorator
public abstract class LogMessageJSONFormatter implements LogMessage {

    @Any
    @Delegate
    @Inject
    @ComplexMessage
    private LogMessage logMessage;

    public void printMessage(){
        String message=logMessage.getMessage();
        message=LocalDate.now().toString().concat(message);
        logMessage.setMessage(message);
    }
}
