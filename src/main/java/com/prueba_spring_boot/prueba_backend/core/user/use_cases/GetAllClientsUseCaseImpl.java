package com.prueba_spring_boot.prueba_backend.core.user.use_cases;

import com.prueba_spring_boot.prueba_backend.core.user.ports.ClientRepositoryService;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.converters.ClientRestConverter;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.ClientRest;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class GetAllClientsUseCaseImpl implements GetAllClientsUseCase {

	private final ClientRepositoryService clientRepositoryService;
	private final ClientRestConverter clientRestConverter;

	@Override
	public Flux<ClientRest> execute() {
		return clientRepositoryService
				.getAllClients()
				.map(clientRestConverter::mapToRest);
	}
}
