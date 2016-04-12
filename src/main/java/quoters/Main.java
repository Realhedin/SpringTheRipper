package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple main to run examples.
 *
 * Created by dkorolev on 4/12/2016.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlContext.xml");
        Quoter quoter = context.getBean(Quoter.class);
        quoter.sayQuote();
    }
}
