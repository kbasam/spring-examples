package kkb.examples.springboot.security.springsecurity.services;

import java.util.Optional;

import kkb.examples.springboot.security.springsecurity.services.dto.LoginRequest;
import kkb.examples.springboot.security.springsecurity.services.dto.SessionId;
import kkb.examples.springboot.security.springsecurity.services.dto.UserData;

public interface UserAccessService {

    Optional<UserData> login(SessionId sessionId, LoginRequest loginRequest);

    Optional<UserData> isAuthenticated(SessionId sessionId);

    void logout(SessionId sessionId);

}
