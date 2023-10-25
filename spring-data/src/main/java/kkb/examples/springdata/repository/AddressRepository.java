package kkb.examples.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kkb.examples.springdata.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, String>  {
}
