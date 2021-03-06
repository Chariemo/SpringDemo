package simpleLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import simpleLogin.model.User;
import simpleLogin.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Charley on 2017/6/1.
 */
@Controller
public class LoginController {

    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage() {

        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {

        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());

        if (!isValidUser) {
            return new ModelAndView("login", "error", "Name or Password is Wrong");
        } else {
            User user = userService.findUserByName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }

    @Autowired
    public void setUserService(UserService userService) {

        this.userService = userService;
    }
}
