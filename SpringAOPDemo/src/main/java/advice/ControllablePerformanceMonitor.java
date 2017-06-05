package advice;

import cglibProxy.Monitorable;
import cglibProxy.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by Charley on 2017/6/4.
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    public void setMonitorActive(boolean active) {

        MonitorStatusMap.set(active);
    }

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Object o = null;

        if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
            PerformanceMonitor.begin(methodInvocation.getClass().getName() + "." + methodInvocation.getMethod().getName());

            o = super.invoke(methodInvocation);
            PerformanceMonitor.end();
        }

        else {
            o = super.invoke(methodInvocation);
        }
        return o;
    }
}
