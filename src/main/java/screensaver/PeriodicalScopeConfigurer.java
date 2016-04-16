package screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * New periodical scope creation.
 * Need to be registered before bean definitions are created
 * => BeanFactoryPostProcessor.
 *
 * Created by dkorolev on 4/16/2016.
 */
public class PeriodicalScopeConfigurer implements Scope {

    Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        //check if bean has already existed
        if (map.containsKey(name)) {
            Pair<LocalTime, Object> pair = map.get(name);
            int secondsSinceLastRequest = LocalTime.now().getSecond() - pair.getKey().getSecond();
            //check if interval is exceeded?
            if (secondsSinceLastRequest > 3) {
                //if exceeded, then create new pair and take bean again (color will be changed randomly)
                map.put(name, new Pair<>(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            //put if not existed
            map.put(name, new Pair<>(LocalTime.now(), objectFactory.getObject()));
        }
        return map.get(name).getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
