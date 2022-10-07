package com.exam.service.impl;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoleSet) throws Exception {
        User localUser = this.userRepository.findByUserName(user.getUserName());
        if(localUser!=null) {
            System.out.println("User is already present !!");
            throw new Exception("User is already present !!");
        } else {
            //user create
            for(UserRole userRole:userRoleSet){
                roleRepository.save(userRole.getRole());
            }

            user.getUserRoleSet().addAll(userRoleSet);
            localUser = this.userRepository.save(user);
        }

        return localUser;
    }

    @Override
    public User getUserByUserName(String userName) throws Exception {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User updateUserByUserName(String userName, User user) throws Exception {
        User localUser = this.userRepository.findByUserName(userName);

        if(localUser==null){
            System.out.println("user does not exist !!");
            throw new Exception("user does not exist !!");
        } else {
            localUser = this.userRepository.save(user);
        }

        return localUser;
    }

}
