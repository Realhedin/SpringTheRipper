package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * ProfilingHandler Post processor to
 * handle classes with annotation Profiling.
 * Plus with MBean parameter.
 *
 * Created by dkorolev on 4/13/2016.
 */
public class ProfilingHandlerPostProcessor implements BeanPostProcessor {

    //here we collect beanNames and its class.
    private Map<String, Class> map = new HashMap<>();
    //controller, which contains flag for JMX.
    private ProfilingController controller = new ProfilingController();

    //register in MBean Server our controller
    public ProfilingHandlerPostProcessor() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    // original bean, name is the same
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        //if class contains annotation Profiling, then save this class in map.
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    //possible changed bean (created via Dynamic proxy or CGLIB)
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        //if this class in map, then it has annotation Profiling and should be recreated with Proxy.
        if (beanClass != null) {
            //create Proxy class with the same ClassLoader and Interfaces,
            //but with additional logic
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    (o, method, args) -> {
                        if (controller.isEnabled()) {
                            //logic for showing time that method works
                            System.out.println("Profiling....");
                            long before = System.nanoTime();
                            Object retValue = method.invoke(bean, args);
                            long after = System.nanoTime();
                            System.out.println(after - before);
                            System.out.println("End of profiling");
                            return retValue;
                        } else {
                            //proxy with no changes
                            return method.invoke(bean,args);
                        }
                    });
        }
        return bean;
    }
}
