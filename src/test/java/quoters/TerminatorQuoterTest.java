package quoters;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test for Terminator implementation.
 *
 * Created by dkorolev on 4/12/2016.
 */
public class TerminatorQuoterTest {

    static Quoter quoter;

    @BeforeClass
    public static void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xmlContext.xml");
        quoter = context.getBean(Quoter.class);
    }

    /**
     * Simple test spring annotation for bean.
     * @throws Exception
     */
    @Test
    public void testSayQuote() throws Exception {
        Assert.assertNotNull(quoter);
        Assert.assertEquals("I'll be back", quoter.sayQuote());
    }

    /**
     * Test InjectRandomIntAnnotationBeanPostProcessor.
     * @throws Exception
     */
    @Test
    public void testGetRepeat() throws Exception {
        Assert.assertTrue(quoter.getRepeat() >= 2);
    }

    /**
     * Test PredefineValueAnnotationBeanPostProcessor.
     * @throws Exception
     */
    @Test
    public void testGetPredefinedString() throws Exception {
        Assert.assertEquals("Come and get it",quoter.getPredefinedString());
    }
}