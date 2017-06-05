package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;
import simpleLogin.model.User;
import simpleLogin.service.UserService;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Charley on 2017/6/1.
 */
@ContextConfiguration("classpath*:/introd-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {

        this.userService = userService;
    }

    @Test
    public void hasMatchUser() {

        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertTrue(!b2);
    }


    @Test
    public void findUserByUserName() {

        User user = userService.findUserByName("admin");
        assertEquals(user.getUserName(), "admin");
    }
}
