package advicer;

import advice.WaiterDelegate;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Created by Charley on 2017/6/4.
 */
public class GreetingComposablePointcut {

    public Pointcut getIntersectionPointcut() {

        ComposablePointcut composablePointcut = new ComposablePointcut();

        Pointcut pointcut1 = new ControlFlowPointcut(WaiterDelegate.class, "service");

        NameMatchMethodPointcut pointcut2 = new NameMatchMethodPointcut();
        pointcut2.addMethodName("greeTo");
        return composablePointcut.intersection(pointcut1).intersection((Pointcut) pointcut2);
    }
}
