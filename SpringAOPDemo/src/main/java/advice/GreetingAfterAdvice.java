package advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Charley on 2017/6/4.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {

        System.out.println("Please enjoy yourself!");
    }
}
