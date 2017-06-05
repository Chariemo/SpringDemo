package advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Charley on 2017/6/4.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {

        String clientName = (String) objects[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
