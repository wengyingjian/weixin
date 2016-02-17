package com.wengyingjian.weixin.controller;

import com.wengyingjian.kylin.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wengyingjian.weixin.common.model.User;
import com.wengyingjian.weixin.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wengyingjian on 16/2/2.
 */

@Controller
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public Result<List<User>> listUsers(HttpServletRequest request,//
                                        @RequestParam(value = "type", required = false) Integer userType) {//

        return userService.listUsers(userType);
    }

    @RequestMapping("update")
    public Result<Boolean> update(HttpServletRequest request,
                                  @RequestParam("user_id") Integer uid,//
                                  @RequestParam(value = "user_name", required = false) String userName,
                                  @RequestParam(value = "user_type", required = false) Integer userType) {
        return userService.modifyUser(uid,userName,userType);
    }
}
