package quoters;

import javax.annotation.PostConstruct;

/**
 * Terminator implementation of Quoter.
 *
 * Created by dkorolev on 4/12/2016.
 */
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max =7)
    private int repeat;

    private String message;

    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    public String sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("Message: " + message);
        }
        return message;
    }


    public int getRepeat() {
        return repeat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
