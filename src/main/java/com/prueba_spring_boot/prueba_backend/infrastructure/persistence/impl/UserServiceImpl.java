package com.prueba_spring_boot.prueba_backend.infrastructure.persistence.impl;

import com.prueba_spring_boot.prueba_backend.core.user.User;
import com.prueba_spring_boot.prueba_backend.core.user.ports.UserRepositoryService;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.repositories.UserRepository;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class UserServiceImpl implements UserRepositoryService {

	private final UserRepository userRepository;

	@Override
	public Mono<Boolean> getUser(User user) {
		return userRepository
				.findByDocumentNumber(user.getDocumentNumber())
				.hasElement();
	}

	@Override
	public Mono<Boolean> validateTypeDocument(User user) {
		if (user.getType().equals("C") || user.getType().equals("P")){
			return getUser(user);
		}
		return Mono.error(new BadRequestException("400 Type not supported"));
	}
}
