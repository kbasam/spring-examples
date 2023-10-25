package kkb.examples.webflux.services;

import kkb.examples.webflux.dto.LoginRequest;
import kkb.examples.webflux.dto.Token;
import reactor.core.publisher.Mono;

public interface LoginService {

    Mono<Token> login(LoginRequest loginRequest);

    boolean validate(Token token);

    Mono<Void> logout(Token token);

}
