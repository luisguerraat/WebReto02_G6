package com.grupog6.sbconmongodb.Repository;

import org.springframework.stereotype.Repository;

import com.grupog6.sbconmongodb.Documents.User;
import com.grupog6.sbconmongodb.MongoRepository.UserMongoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserRepository {
    @Autowired
    private UserMongoRepository userMongoRepository;
    
    public List<User> getAll() {
        return (List<User>) userMongoRepository.findAll();
    }

    public User addUser(User user) {
        return userMongoRepository.save(user);
    }

    public User udpUser(User user) {
        return userMongoRepository.save(user);
    }

    public void delUser(Integer id) {
        userMongoRepository.deleteById(id);
    }

    public User getUserById(Integer id) {
        Optional<User> myUser = userMongoRepository.findById(id);
        User userrespuesta = new User();

        if (myUser.isPresent()) {
            userrespuesta = myUser.get();
        } 
        return userrespuesta;
    }


    public boolean getValidateEmail(String email) {
        Optional<User> miUsuario = userMongoRepository.findByEmail(email);

        if (miUsuario.isEmpty())
            return false;
        else
            return true;
    }
    
    public User getLogin(String email, String password) {
        Optional<User> miUsuario = userMongoRepository.findByEmailAndPassword(email, password);
        User usuarioRespuesta = new User();

        if (miUsuario.isPresent()) {
             usuarioRespuesta = miUsuario.get();
         } 
         return usuarioRespuesta;
    }

}
