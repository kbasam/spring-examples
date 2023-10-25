package kkb.examples.springboot.security.services;

import kkb.examples.springboot.security.services.dto.ServerData;

public interface DataService {

    public void setState(String state);

    ServerData getSecuredData(String source);

}
