# SpringTheRipper
Practice from Spring the Ripper lectures by Evgenii Borisov.


1. Simple TerminatorQuoter with xml context + Main + Test.
    Just class with Spring context, main to run and jUnit test.

2. Added new InjectRandomInt annotation and Bean Post Processor for it.
    Added annotation InjectRandomInt to inject in a field a random int number.
    And Bean Post Processor was written for it.
    (works during bean creation, before init (@PostConstruct).

3. 2 phase constructor.
    Added @PostConstruct on init method to show 2 phase constructor.
    (Init method is run after postProcessBeforeInitialization() in BPP)

4. Added PredefineValue annotation and Bean Post Processor for it.
    My version of setting String value into a fields (see 2.)

5. Added Profiling annotation and BPP and MBean parameter for JMX.
    Added Profiling annotation to count time for each methods in a class
    with this annotation. BPP was written (the main logic is inside
     postProcessAfterInitialization() because we change object by creating
     a new Proxy from it).
     Plus, we register Mbean for it to be able to change its value on runtime
     via JMX (via JVMConsole tool).

6. Added PostProxy annotation and PostProxyInvokerContextListener for it.
    Added PostProxy annotation and ContextListener for it on ContextRefreshedEvent.
    This is 3 phase constructor which takes place after BPP.
    So beans are completely ready to use when ContextRefreshedEvent is called.

7. Added DeprecatedClass annotation and DeprecationHandlerBeanFactoryPostProcessor for it.
    Allows to change beanDefinitions by BeanFactoryPostProcessor before any beans are created.
    (In our example, it changes name and as a result - another bean will be created)
    [currently commented annotation in TerminatorQuoter]