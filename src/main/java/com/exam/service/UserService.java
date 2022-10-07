package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoleSet) throws Exception;
    //get user by username
    public User getUserByUserName(String userName) throws Exception;
    //delete user by id
    public void deleteUserById(Long id);
    //updateUserbyusername
    public User updateUserByUserName(String userName, User user) throws Exception;
}
