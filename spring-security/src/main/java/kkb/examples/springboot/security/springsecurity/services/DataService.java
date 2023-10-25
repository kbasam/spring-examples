package kkb.examples.springboot.security.springsecurity.services;

import kkb.examples.springboot.security.springsecurity.services.dto.ServerData;

public interface DataService {

    ServerData getSecuredData(String source);

}
