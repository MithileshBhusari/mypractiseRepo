package com.mtb.decoratorex;

import com.mtb.decoratorex.readLearncode.LogMessage;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.time.LocalDate;

/**
 * @author MithileshB
 * @created 22/07/2020 - 9:26 AM
 * @project DesignPattern
 */
@Priority(10)
@Decorator
public abstract class LogMessageFormatter implements LogMessage {

    @Any
    @Delegate
    @Inject
    @ComplexMessage
    private LogMessage logMessage;
    public void printMessage() {
        String message=logMessage.getMessage();
        message=LocalDate.now().toString().concat(message);
        logMessage.setMessage(message);
    }
}
