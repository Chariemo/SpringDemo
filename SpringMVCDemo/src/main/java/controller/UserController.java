package controller;

import model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Charley on 2017/6/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "handler51")
    public ResponseEntity<User> handler51(HttpEntity<User> requestEntity) {

        User user = requestEntity.getBody();
        user.setUserId(1000);
        System.out.println(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
