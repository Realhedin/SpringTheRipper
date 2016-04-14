package quoters.contextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import quoters.annotations.PostProxy;

import java.lang.reflect.Method;

/**
 * Allow run method with annotation PostProxy.
 *
 * Created by dkorolev on 4/14/2016.
 */
public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        //names are from our Proxy, that is why we can't get class from it
        for (String name : names) {
            //so we use factory to get original class name
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                //get original class
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] methods = originalClass.getMethods();
                //methods of Original class'a, but we need methods from Proxy
                for (Method method : methods) {
                    if (method.isAnnotationPresent(PostProxy.class)) {
                        Object bean = context.getBean(name);
                        Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                        currentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
