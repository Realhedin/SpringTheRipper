package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple main to run examples.
 *
 * Created by dkorolev on 4/12/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlContext.xml");
        while (true) {
            Thread.sleep(1000);
            Quoter quoter = context.getBean(Quoter.class);
            quoter.sayQuote();
        }
    }
}
