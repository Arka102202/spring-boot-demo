package com.springBootDemo.springbootdemoall.repository;

import com.springBootDemo.springbootdemoall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

//    @Query("FROM User u WHERE u.firstName = ?1 AND u.password = ?2")
//    User findByFirstNameAndPassword(String firstName, String password);

//    same as the above
    User findByFirstNameAndPassword(String firstName, String password);

    @Modifying
    @Query(value = "UPDATE user set user_login_status = ?2 where user_id = ?1", nativeQuery = true)
    void updateUserLoginStatus(int id, int status);

}
