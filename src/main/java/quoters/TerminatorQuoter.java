package quoters;

/**
 * Terminator implementation of Quoter.
 *
 * Created by dkorolev on 4/12/2016.
 */
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max =7)
    private int repeat;

    private String message;

    public String sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("Message: " + message);
        }
        return message;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
