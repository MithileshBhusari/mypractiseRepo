package mtb.decorator;

import mtb.decorator.thirdpartylogger.LogMessage;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.time.LocalDate;

/**
 * @author MithileshB
 * @created 20/07/2020 - 1:02 PM
 * @project DesignPattern
 */
@Decorator
public abstract class LogMessageFormatter implements LogMessage {

    @Any
    @Delegate
    @Inject
    private LogMessage logMessage;

    @Override
    public void printMessage() {
        String message=logMessage.getMessage();
        message= LocalDate.now().toString().concat(message);
        logMessage.setMessage(message);
    }
}
