package com.prueba_spring_boot.prueba_backend.infrastructure.persistence.impl;

import com.prueba_spring_boot.prueba_backend.core.user.Client;
import com.prueba_spring_boot.prueba_backend.core.user.ports.ClientRepositoryService;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.converters.ClientRepositoryConverter;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class ClientServiceImpl implements ClientRepositoryService {

	private final ClientRepository clientRepository;

	private final ClientRepositoryConverter clientRepositoryConverter;

	@Override
	public Flux<Client> getAllClients() {
		return clientRepository
				.findAll()
				.map(clientRepositoryConverter::mapToEntity);
	}
}
