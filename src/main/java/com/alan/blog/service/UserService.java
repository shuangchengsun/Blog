package com.alan.blog.service;

import com.alan.blog.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface UserService {

    User checkUser (String username, String password);

    boolean userLogin(String username, String password, HttpSession session, HttpServletResponse response) throws JsonProcessingException;

    void saveUser(User user);

    void userSignIn(User user, HttpSession session, HttpServletResponse response);

    void userLogout(HttpSession session, HttpServletResponse response);

    boolean checkLogin(HttpServletRequest request, HttpServletResponse response);

    User getTestUser();
}
