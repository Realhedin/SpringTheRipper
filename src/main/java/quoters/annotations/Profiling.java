package quoters.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for profiling
 * for postProcessAfterInitialization.
 *
 * Add additional logic to each method
 * of annotated class by creating new class
 * with help of proxy.
 *
 * Created by dkorolev on 4/13/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
}
