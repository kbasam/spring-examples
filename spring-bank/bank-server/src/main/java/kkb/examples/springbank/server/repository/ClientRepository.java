package kkb.examples.springbank.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kkb.examples.springbank.server.repository.model.ClientEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findById(Long id);

    List<ClientEntity> findAll();

    void delete(ClientEntity entity);

    void deleteById(Long id);

}
