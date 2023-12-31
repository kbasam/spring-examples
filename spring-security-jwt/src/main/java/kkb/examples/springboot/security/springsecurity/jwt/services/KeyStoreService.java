package kkb.examples.springboot.security.springsecurity.jwt.services;

import java.security.Key;
import java.util.Optional;

import kkb.examples.springboot.security.springsecurity.jwt.services.dto.UserId;

/**
 * KeyStore service responsible for user key management.
 */
public interface KeyStoreService {

    /**
     * Get private key of CA.
     * @return
     */
    Key getCertificationAuthorityKey();

    /**
     * Create key for given user and store it in cache.
     * @param userId
     * @return
     */
    Key createUserKey(UserId userId);

    /**
     * Get user key from cache.
     * @param userId
     * @return
     */
    Optional<Key> getUserKey(UserId userId);

    /**
     * Remove user key from cache.
     * @param userId
     * @return
     */
    boolean removeUserKey(UserId userId);

}
