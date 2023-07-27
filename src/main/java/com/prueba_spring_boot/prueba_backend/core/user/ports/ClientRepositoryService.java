package com.prueba_spring_boot.prueba_backend.core.user.ports;

import com.prueba_spring_boot.prueba_backend.core.user.Client;
import reactor.core.publisher.Flux;

public interface ClientRepositoryService {

	public Flux<Client> getAllClients();
}
