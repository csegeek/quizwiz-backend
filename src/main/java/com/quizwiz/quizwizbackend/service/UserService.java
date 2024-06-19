package com.quizwiz.quizwizbackend.service;

import com.quizwiz.quizwizbackend.entities.User;
import com.quizwiz.quizwizbackend.entities.UserRole;
import com.quizwiz.quizwizbackend.repository.RoleRepository;
import com.quizwiz.quizwizbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        Optional<User> optionalUser = this.userRepository.findByUserName(user.getUsername());
        if (optionalUser.isPresent()) {
            System.out.println("User is already there !!");
            throw new Exception("User is alrady present");
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            return this.userRepository.save(user);
        }

    }

   public User getUser(String username) {
        return this.userRepository.findByUserName(username).get();
    }

    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

}
