package com.group2.baitap4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void saveOrUpdate(UserModel user){
        userRepository.save(user);
    }

    public Iterable<UserModel> getAllUsers(){
        return userRepository.findAll();
    }
}
