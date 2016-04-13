package quoters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * New created annotation for setting declarative
 * random number.
 *
 * add value to field with annotation.
 *
 * Created by dkorolev on 4/12/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int min();
    int max();

}
