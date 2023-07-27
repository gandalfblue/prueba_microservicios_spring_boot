package com.prueba_spring_boot.prueba_backend.infrastructure.delivery.converters;

import com.prueba_spring_boot.prueba_backend.core.user.Client;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.ClientRest;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.RestConverter;

public class ClientRestConverter implements RestConverter<ClientRest, Client> {

	@Override
	public Client mapToEntity(final ClientRest rest) {

		return new Client(rest.getId(), rest.getFirst_name(), rest.getSecond_name(), rest.getSurname(),
				rest.getSecond_surname(), rest.getCity_of_residence(), rest.getPhone(), rest.getAddress());
	}

	@Override
	public ClientRest mapToRest(final Client entity) {
		return new ClientRest(entity.getId(), entity.getFirst_name(), entity.getSecond_name(), entity.getSurname(),
				entity.getSecond_surname(), entity.getCity_of_residence(), entity.getPhone(), entity.getAddress());
	}

}
