package com.alan.blog.controller.admin;

import com.alan.blog.model.User;
import com.alan.blog.service.UserService;
import com.alan.blog.util.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/admin")
/*用于鉴权*/
public class Authentication {

    @Autowired
    private UserService userService;


    /*访问登陆页面*/
    @GetMapping("/")
    public String getLogin() {
        return "admin/login";
    }

    /*提交登录信息，并审核*/
    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        HttpSession session,
                        HttpServletResponse response,
                        Model model) throws JsonProcessingException {

        if (!userService.userLogin(userName, password, session, response)) {
            /*登录不成功*/
            model.addAttribute("error", "用户名或密码不正确");
            return "admin/login";
        } else {
            /*登录成功*/
            return "redirect:/admin/index";
        }
    }

    @GetMapping("/signin")
    public String getSignIn() {
        return "admin/signIn";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam("userName") String username,
                         @RequestParam("password") String password,
                         @RequestParam("email") String email,
                         @RequestParam("nickName") String nickName,
                         HttpSession session,
                         HttpServletResponse response) {

        /*构造User*/
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setCreateTime(new Date(System.currentTimeMillis()));
        user.setEmail(email);
        user.setNickName(nickName);
        user.setBlogs(null);
        user.setAvatar("https://unsplash.it/800/400?image=1005");
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        user.setType(0);
        user.setToken(TokenUtil.getToken());
        /*完成注册相关业务*/

        userService.userSignIn(user, session, response);
        return "redirect:/admin/index";

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.removeAttribute("user");
        userService.userLogout(session, response);
        return "redirect:/";
    }

}
