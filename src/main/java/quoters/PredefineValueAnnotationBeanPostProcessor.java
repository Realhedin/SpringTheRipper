package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * My test BeanPostProcessor for Predefined String
 *
 * Created by dkorolev on 4/13/2016.
 */
public class PredefineValueAnnotationBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            PredefineValue predefineValueAnnotation = field.getAnnotation(PredefineValue.class);
            if (predefineValueAnnotation != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field,bean,predefineValueAnnotation.value());
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
