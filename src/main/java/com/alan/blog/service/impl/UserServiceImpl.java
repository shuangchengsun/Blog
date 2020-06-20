package com.alan.blog.service.impl;

import com.alan.blog.Exception.RedisException;
import com.alan.blog.dao.UserDAOService;
import com.alan.blog.model.User;
import com.alan.blog.service.UserService;
import com.alan.blog.util.EncryptUtil;
import com.alan.blog.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAOService userDAOService;

    private void updateToken(User user) {
        String newToken = TokenUtil.getToken();
        String oldToken = user.getToken();
        user.setToken(newToken);
        if (oldToken == null) {
            LOGGER.info("when updateToken, the oldToken is null, updateToken failed!");
            return;
        }
        try {
            userDAOService.updateToken(newToken, user, oldToken);
        } catch (RedisException exception) {
            LOGGER.error(exception.getMessage());
        }
    }

    @Override
    public User checkUser(String username, String password) {
        String sp = EncryptUtil.MD5(password);
        User user = userDAOService.getUserByNameAndPassword(username, sp);
        return user;
    }

    @Override
    /*用户登录*/
    public boolean userLogin(String username, String password, HttpSession session, HttpServletResponse response) {
        User user = this.checkUser(username, password);     // 检查用户密码对不对
        if (user == null) {
            return false;
        } else {
            /*先更新用户的token，*/
            String newToken = TokenUtil.getToken();
            String oldToken = user.getToken();
            user.setToken(newToken);
            userDAOService.updateToken(newToken, user, oldToken);
            /*将用户加入到session中*/
            session.setAttribute("user", user);
            /*再将明文token加入到cookie中*/
            Cookie cookie = new Cookie("token", newToken);
            /*cookie 十分钟有效期*/
            cookie.setMaxAge(10 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            return true;

        }
    }


    @Override
    /*校验用户是否曾经登录过*/
    public boolean checkLogin(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser != null) {
            /*session中存在user，说明已经登录过了*/
            /*更新cookie中的token*/
            this.updateToken(sessionUser);
            Cookie cookie = new Cookie("token", sessionUser.getToken());
            cookie.setPath("/");
            cookie.setMaxAge(5 * 60);
            response.addCookie(cookie);
            return true;

        } else {
            /*session中没有user，在cookie找token*/
            String token = null;
            /*获取cookie中的token*/
            if (cookies == null || cookies.length == 0) {
                return false;
            }
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
            if (token != null) {
                /*存在则依据token查询User*/
                token = token.replace("-", "");
                LOGGER.info("get a cookie token " + token);
                User user = userDAOService.getByToken(token);
                if (user != null) {
                    /*查询到user则说明token有效，更新token*/
                    this.updateToken(user);
                    /*存入session*/
                    session.setAttribute("user", user);
                    /*回写cookie*/
                    Cookie cookie = new Cookie("token", user.getToken());
                    cookie.setMaxAge(10 * 60);
                    response.addCookie(cookie);
                    return true;
                } else {
                    return false;
                }
            } else {
                /*未发现用户登录的痕迹*/
                LOGGER.info("token not found");
                return false;
            }
        }

    }

    @Override
    /*向数据库中写入一个user*/
    public void saveUser(User user) {
        userDAOService.setUser(user);
    }

    @Override
    /*处理用户注册的逻辑*/
    public void userSignIn(User user, HttpSession session, HttpServletResponse response) {

        String token = user.getToken();
        LOGGER.info("signIn set token " + token);
        user.setToken(EncryptUtil.MD5(user.getToken()));
        user.setPassword(EncryptUtil.MD5(user.getPassword()));
        this.saveUser(user);

        session.setAttribute("user", user);

        /*cookie保存明文token，数据库中保存加密token*/
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(10 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

    }

    @Override
    /*处理用户登出逻辑*/
    public void userLogout(HttpSession session, HttpServletResponse response) {
        User user = (User) session.getAttribute("user");
        session.removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public User getTestUser() {
        return userDAOService.getUserByName("alan");
    }


    @Override
    public void userOff(User user) {

    }
}
