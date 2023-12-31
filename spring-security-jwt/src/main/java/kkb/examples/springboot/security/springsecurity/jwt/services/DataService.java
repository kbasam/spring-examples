package kkb.examples.springboot.security.springsecurity.jwt.services;


import kkb.examples.springboot.security.springsecurity.jwt.services.dto.ServerData;

/**
 * Service providing protected data.
 */
public interface DataService {

    /**
     * Get data for source.
     * @param source source identifier or name.
     * @return
     */
    ServerData getSecuredData(String source);

}
