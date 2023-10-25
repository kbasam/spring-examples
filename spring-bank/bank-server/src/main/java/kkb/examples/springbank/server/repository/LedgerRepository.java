package kkb.examples.springbank.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kkb.examples.springbank.server.repository.model.LedgerEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface LedgerRepository extends JpaRepository<LedgerEntity, Long> {

    Optional<LedgerEntity> findById(Long id);

    List<LedgerEntity> findAll();

    void delete(LedgerEntity entity);

}
