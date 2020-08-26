package mtb.decorator.thirdpartylogger;

/**
 * @author MithileshB
 * @created 20/07/2020 - 1:01 PM
 * @project DesignPattern
 */
public interface LogMessage {
    void printMessage();
    String getMessage();
    void setMessage(String message);
}
