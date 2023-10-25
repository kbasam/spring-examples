package kkb.examples.springboot.security.springsecurity.jwt.services;

import org.springframework.stereotype.Service;

import kkb.examples.springboot.security.springsecurity.jwt.services.dto.ServerData;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public ServerData getSecuredData(String source) {
        return new ServerData(source, "Some Data", System.currentTimeMillis());
    }

}
