package com.prueba_spring_boot.prueba_backend.core.user.ports;

import com.prueba_spring_boot.prueba_backend.core.user.User;
import reactor.core.publisher.Mono;

public interface UserRepositoryService {

	public Mono<Boolean> getUser(User user);

	public Mono<Boolean> validateTypeDocument(User user);
}
