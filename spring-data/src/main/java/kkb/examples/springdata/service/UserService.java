package kkb.examples.springdata.service;

import java.util.Collection;

import kkb.examples.springdata.entity.UserEntity;

public interface UserService {

    String createUser(String name, String email);

    Collection<UserEntity> getAll();

    void deleteUser(String id);

}
