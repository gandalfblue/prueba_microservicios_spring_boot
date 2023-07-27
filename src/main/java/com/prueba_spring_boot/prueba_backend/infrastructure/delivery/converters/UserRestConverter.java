package com.prueba_spring_boot.prueba_backend.infrastructure.delivery.converters;

import com.prueba_spring_boot.prueba_backend.core.user.User;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.UserRest;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.RestConverter;

public class UserRestConverter implements RestConverter<UserRest, User> {

	@Override
	public User mapToEntity(final UserRest rest) {
		return new User(rest.getId(), rest.getType(),
				rest.getDocumentNumber());
	}

	@Override
	public UserRest mapToRest(final User entity) {
		return new UserRest(entity.getId(), entity.getType(),
				entity.getDocumentNumber());
	}

}
