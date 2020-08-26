package com.alan.blog.dal.dao.repository;

import com.alan.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameAndPassword(String username, String password);

    User findByToken(String token);

    User findByUserName(String name);

    @Modifying
    @Query("update User user set user.token=?1 where user.id=?2")
    void updateTokenById(String token, Long id);



}
