package advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Charley on 2017/6/4.
 */
public class GreetingInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];

        System.out.println("How are you! Mr." + clientName + ".");

        Object object = methodInvocation.proceed();

        System.out.println("Please enjoy YourSelf!");

        return object;

    }
}
