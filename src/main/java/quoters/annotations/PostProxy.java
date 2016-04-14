package quoters.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to work with ContextListener.
 * After all beans are created.
 * Allow to run method.
 *
 * Created by dkorolev on 4/14/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PostProxy {
}
