package quoters;

/**
 * Terminator implementation of Quoter.
 *
 * Created by dkorolev on 4/12/2016.
 */
public class TerminatorQuoter implements Quoter {

    private String message;

    public String sayQuote() {
        System.out.println("Message: " + message);
        return message;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
