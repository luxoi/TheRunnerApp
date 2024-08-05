package com.luxoi.therunnerapp.therunnerapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll(){

        return userRepository.findAll();
    }

    public UserModel saveUser(UserModel userModel){
        return userRepository.save(userModel);
    }

    public UserModel findById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            // Lanza una excepción personalizada si el usuario no se encuentra
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    public void deleteUser(UserModel userModel){
        userRepository.delete(userModel);
    }
}
