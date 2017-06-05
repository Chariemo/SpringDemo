package advice;

import cglibProxy.ForumService;
import cglibProxy.Monitorable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;

import static org.junit.Assert.*;

/**
 * Created by Charley on 2017/6/4.
 */
public class GreetingAdviceTest {

    @org.junit.Test
    public void aopTest() throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-context.xml");
//        Waiter waiter = (Waiter) ctx.getBean("waiter");
//        waiter.greeTo("Charley");

//        引介增强测试
//        ForumService forumService = (ForumService) ctx.getBean("forumService");
//
//        forumService.removeForum(20);
//        forumService.removeTopic(40);
//
//        Monitorable monitorable = (Monitorable) forumService;
//        monitorable.setMonitorActive(true);
//
//        forumService.removeForum(20);
//        forumService.removeTopic(40);

        //测试复合切点切面
//        Waiter waiter = (Waiter) ctx.getBean("waiter2");
//        WaiterDelegate waiterDelegate = new WaiterDelegate();
//        waiterDelegate.setWaiter(waiter);
//        waiter.serveTo("Charie");
//        waiter.greeTo("Chaire");
//
//        waiterDelegate.service("Charie");


        //动态切面测试+自动创建代理
        Waiter waiter = (Waiter) ctx.getBean("target");
        waiter.serveTo("Li");
        waiter.greeTo("Li");

        waiter.serveTo("Charie");
        waiter.greeTo("Riemo");

    }

}