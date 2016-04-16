package screensaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Simple main for screensaver.
 *
 * Created by dkorolev on 4/16/2016.
 */
public class ScreensaverMain {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(200);
        }
    }
}
