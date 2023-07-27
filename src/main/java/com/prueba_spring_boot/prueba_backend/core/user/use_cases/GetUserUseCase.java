package com.prueba_spring_boot.prueba_backend.core.user.use_cases;

import com.prueba_spring_boot.prueba_backend.core.user.User;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.ClientRest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GetUserUseCase {
	public Flux<ClientRest> execute(User user);
}
