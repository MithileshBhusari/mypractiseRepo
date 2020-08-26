package mtb.decorator;

import mtb.decorator.thirdpartylogger.LogMessage;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * @author MithileshB
 * @created 20/07/2020 - 1:06 PM
 * @project DesignPattern
 */
@Decorator
public abstract class LogMessageJSONFormatter implements LogMessage {

    @Any
    @Delegate
    @Inject
    private LogMessage logMessage;

    public void printMessage(){
        String  message=logMessage.getMessage();
        String jsonMessage=JsonBuil
    }
}
