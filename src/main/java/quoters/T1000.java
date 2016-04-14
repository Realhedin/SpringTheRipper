package quoters;

/**
 * New version of TerminatorQuoter.
 * All beanDefinitions with @DeprecatedClass should
 * be changed to T1000.
 *
 * Created by dkorolev on 4/14/2016.
 */
public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
    public String sayQuote() {
        System.out.println("I am T1000");
        setMessage("I am T1000");
        return getMessage();
    }
}
