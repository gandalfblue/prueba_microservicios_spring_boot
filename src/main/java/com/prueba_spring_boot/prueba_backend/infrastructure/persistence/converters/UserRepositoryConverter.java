package com.prueba_spring_boot.prueba_backend.infrastructure.persistence.converters;

import com.prueba_spring_boot.prueba_backend.core.user.User;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.entities.UserEntity;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.RepositoryConverter;

public class UserRepositoryConverter implements RepositoryConverter<UserEntity, User> {

	@Override
	public UserEntity mapToDocument(final User persistenceObject) {
		return new UserEntity(persistenceObject.getId(), persistenceObject.getType(),
				persistenceObject.getDocumentNumber());
	}

	@Override
	public User mapToEntity(final UserEntity entityObject) {
		return new User(entityObject.getId(), entityObject.getType(),
				entityObject.getDocumentNumber());
	}
}
