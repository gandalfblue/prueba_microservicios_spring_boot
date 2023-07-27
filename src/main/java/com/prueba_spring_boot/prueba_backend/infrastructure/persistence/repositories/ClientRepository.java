package com.prueba_spring_boot.prueba_backend.infrastructure.persistence.repositories;

import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.entities.ClientEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<ClientEntity, String> {
}
