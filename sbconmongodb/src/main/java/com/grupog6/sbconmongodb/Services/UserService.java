package com.grupog6.sbconmongodb.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupog6.sbconmongodb.Documents.User;
import com.grupog6.sbconmongodb.Repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return (List<User>) userRepository.getAll();
    }

    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    public Boolean getValidateEmail(String email) {
        return userRepository.getValidateEmail(email);
    }

    public User getLogin(String email, String password) {
        return userRepository.getLogin(email, password);
    }
    
    public User udpUser(User user){
        User myUser = userRepository.getUserById(user.getId());

        if (myUser.getName().equals("No Encontrado") == false)
            return userRepository.udpUser(user);
        else
            return user;
    }

    public void delUser(Integer id) {
        User myUser = userRepository.getUserById(id);

        if (myUser.getName().equals("No Encontrado") == false)
            userRepository.delUser(id);
    }

    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

}
