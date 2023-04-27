package com.logicbig.example.data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Users addUser(Users users){
        return userRepository.save(users);
    }

    public boolean userExist(String username){
        try{
            userRepository.findByUsername(username).get(0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Users getUser(String username){
        return userRepository.findByUsername(username).get(0);
    }
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    public Users updateUsers(Users users){
        if(userRepository.findByUsername(users.getUsername()).size() == 0){
            return userRepository.save(users);
        }
        return null;
    }
    public void deleteUser(Long username){
        userRepository.deleteById(username);
    }

    public void flush() {
        userRepository.flush();
    }

    public String getValueOfPassword(String username) {
        return userRepository.findByUsername(username).get(0).getPassword();
    }

}
