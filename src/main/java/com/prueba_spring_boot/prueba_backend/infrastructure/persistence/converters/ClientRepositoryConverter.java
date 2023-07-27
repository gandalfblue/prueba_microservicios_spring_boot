package com.prueba_spring_boot.prueba_backend.infrastructure.persistence.converters;

import com.prueba_spring_boot.prueba_backend.core.user.Client;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.entities.ClientEntity;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.RepositoryConverter;

public class ClientRepositoryConverter implements RepositoryConverter<ClientEntity, Client> {

	@Override
	public ClientEntity mapToDocument(final Client persistenceObject) {
		return new ClientEntity(persistenceObject.getId(), persistenceObject.getFirst_name(),
				persistenceObject.getSecond_name(),	persistenceObject.getSurname(), persistenceObject.getSecond_surname(),
				persistenceObject.getCity_of_residence(), persistenceObject.getPhone(), persistenceObject.getAddress());
	}

	@Override
	public Client mapToEntity(final ClientEntity entityObject) {
		return new Client(entityObject.getId(), entityObject.getFirst_name(), entityObject.getSecond_name(),
				entityObject.getSurname(), entityObject.getSecond_surname(), entityObject.getCity_of_residence(),
				entityObject.getPhone(), entityObject.getAddress());
	}
}
