package com.prueba_spring_boot.prueba_backend.infrastructure.persistence.repositories;

import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserEntity, String> {

    Mono<UserEntity> findByDocumentNumber(Integer document_number);
}
