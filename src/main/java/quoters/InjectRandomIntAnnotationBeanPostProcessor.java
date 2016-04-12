package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Bean Post Processor to handle InjectRandomInt annotation.
 *
 * Created by dkorolev on 4/12/2016.
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //get all fields
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            //get annotation
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            //if annotation InjectRandomInt takes place
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int i = min + random.nextInt(max - min);
                //set i into the field
                field.setAccessible(true);
                ReflectionUtils.setField(field,bean,i);
//                    field.set(bean, i);

            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
