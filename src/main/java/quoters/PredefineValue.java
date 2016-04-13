package quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for setting value into field.
 *
 * add value to field with annotation.
 *
 * Created by dkorolev on 4/13/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PredefineValue {
    String value();
}
