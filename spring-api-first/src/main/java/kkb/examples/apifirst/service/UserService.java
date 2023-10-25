package kkb.examples.apifirst.service;

import java.util.List;

import kkb.examples.apifirst.model.User;

public interface UserService {

    List<User> getUsers();

    User createUser(String name, String email, Boolean enabled);

    void delete(String id);

}
