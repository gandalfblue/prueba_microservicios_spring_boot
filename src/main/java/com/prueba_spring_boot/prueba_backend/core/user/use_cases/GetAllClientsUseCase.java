package com.prueba_spring_boot.prueba_backend.core.user.use_cases;

import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.ClientRest;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface GetAllClientsUseCase {
	public Flux<ClientRest> execute();
}
