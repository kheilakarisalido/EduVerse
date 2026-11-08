package com.csit321g3.agenda.eduverse.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csit321g3.agenda.eduverse.entity.User;
import com.csit321g3.agenda.eduverse.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository urepo;

    //C
    public User postUser(User user) {
        return urepo.save(user);
    }

    //R all
    public List<User> getAllUsers() {
        return urepo.findAll();
    }

    //R one
    public User getUserById(Long id) {
        return urepo.findById(id).get();
    }

    //U
    public User putUser(Long id, User newUserDetails) {

        User user = newUserDetails;

        try {
            user = urepo.findById(id).get();

            user.setEmail(newUserDetails.getEmail());
            user.setPassword(newUserDetails.getPassword());
            user.setRole(newUserDetails.getRole());
            user.setCreatedAt(newUserDetails.getCreatedAt());
            user.setLastLoginTime(newUserDetails.getLastLoginTime());
            user.setCampus(newUserDetails.getCampus());

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("User ID " + id + " not found.");
        }

        return urepo.save(user);
    }

    //D
    public String deleteUser(Long id) {

        String msg = "";

        if (urepo.findById(id).isPresent()) {
            urepo.deleteById(id);
            msg = "User ID " + id + " successfully deleted.";
        } else {
            msg = "User ID " + id + " not found.";
        }

        return msg;
    }
}