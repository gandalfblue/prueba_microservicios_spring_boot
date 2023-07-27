package com.prueba_spring_boot.prueba_backend.infrastructure.delivery;

import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.responses.UserResponse;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.ClientRest;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.UserRest;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.exceptions.UserException;
import reactor.core.publisher.Flux;

public interface UserController {

	Flux<UserResponse<ClientRest>> getAllClients(UserRest userRest) throws UserException;
}
