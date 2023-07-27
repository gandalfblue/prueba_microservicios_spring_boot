package com.prueba_spring_boot.prueba_backend.infrastructure.shared;

import java.io.Serializable;

public interface RepositoryConverter<T extends Serializable, P extends Serializable> {

	default T mapToDocument(final P persistenceObject) {
		throw new UnsupportedOperationException();
	}

	default P mapToEntity(final T tableObject) {
		throw new UnsupportedOperationException();
	}

}
