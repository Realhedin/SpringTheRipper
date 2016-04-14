package quoters.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation extends @Deprecated
 * to allow to use newly created class
 * for substitute outdated.
 *
 * Created by dkorolev on 4/14/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
    Class newImpl();
}
