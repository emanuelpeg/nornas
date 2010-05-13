package org.assembly.nornas.sandbox.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class encargada de cargar el contexto spring.
 *
 * @author Emanuel
 */
public class SpringContext {

    private static SpringContext instance;

    private ApplicationContext context;

    private SpringContext(String[] files) {
        // Cargar el contexto de spring
        context = new ClassPathXmlApplicationContext(
                files);

    }

    public static SpringContext getInstance(String[] files) {
        if (instance == null) {
            instance = new SpringContext(files);
        }
        return instance;
    }

    public ApplicationContext getContext() {
        return context;
    }

}
