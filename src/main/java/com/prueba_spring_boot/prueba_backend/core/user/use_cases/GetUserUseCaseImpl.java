package com.prueba_spring_boot.prueba_backend.core.user.use_cases;

import com.prueba_spring_boot.prueba_backend.core.user.User;
import com.prueba_spring_boot.prueba_backend.core.user.ports.UserRepositoryService;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.ClientRest;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.impl.UserServiceImpl;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {

	private final UserRepositoryService userService;
	private final GetAllClientsUseCaseImpl getAllClientsUseCase;

	@Override
	public Flux<ClientRest> execute(User user) {
		return userService
				.validateTypeDocument(user)
				.flatMapMany(userExist ->{
					if (!userExist) {
						return Flux.error(new NotFoundException("404 User Not Found"));
					}
					return getAllClientsUseCase
							.execute();
				});
	}
}
