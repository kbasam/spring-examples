package kkb.examples.springboot.security.services;

import org.springframework.stereotype.Service;

import kkb.examples.springboot.security.services.dto.ServerData;

@Service
public class DataServiceImpl implements DataService {

    private String state;

    public DataServiceImpl() {
        this.state = "DEFAULT";
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public ServerData getSecuredData(String source) {
        return new ServerData(source, "Some Data", System.currentTimeMillis(), state);
    }

}
