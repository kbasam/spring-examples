package kkb.examples.springboot.security.services;

import java.util.Optional;

import kkb.examples.springboot.security.services.dto.LoginRequest;
import kkb.examples.springboot.security.services.dto.UserData;

public interface UserAccessService {

    Optional<UserData> login(String sessionId, LoginRequest loginRequest);

    Optional<UserData> isAuthenticated(String sessionId);

    void logout(String sessionId);

}
