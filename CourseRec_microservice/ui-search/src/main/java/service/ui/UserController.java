package service.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.clients.UserClient;
import service.models.User;

/**
 * Created by wuton on 2017/6/27.
 */

@Controller
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserClient userClient;

    @RequestMapping("/findAll")
    public Iterable<User> findAll(){
        return userClient.findAll();
    }

    @RequestMapping("/save")
    public void save(){
        userClient.save();
        System.out.println("ui save ok");
    }

}
