package com.prueba_spring_boot.prueba_backend.infrastructure.configuration;

import com.prueba_spring_boot.prueba_backend.core.user.use_cases.GetAllClientsUseCaseImpl;
import com.prueba_spring_boot.prueba_backend.core.user.use_cases.GetUserUseCaseImpl;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.converters.ClientRestConverter;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.converters.UserRestConverter;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.converters.ClientRepositoryConverter;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.converters.UserRepositoryConverter;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.impl.ClientServiceImpl;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.impl.UserServiceImpl;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.repositories.ClientRepository;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

	private final UserRepository userRepository;
	private final ClientRepository clientRepository;


	public GeneralConfiguration(UserRepository userRepository, ClientRepository clientRepository) {
		this.userRepository = userRepository;
		this.clientRepository = clientRepository;
	}

	@Bean
	public UserRepositoryConverter userRepositoryConverterBean() {
		return new UserRepositoryConverter();
	}

	@Bean
	public ClientRepositoryConverter clientRepositoryConverterBean() {
		return new ClientRepositoryConverter();
	}
	@Bean
	public UserRestConverter userRestConverterBean() {
		return new UserRestConverter();
	}

	@Bean
	public ClientRestConverter clientRestConverterBean() {
		return new ClientRestConverter();
	}
	@Bean
	public UserServiceImpl userServiceImplBean() {
		return new UserServiceImpl(userRepository);
	}

	@Bean
	public ClientServiceImpl clientServiceImplBean() {
		return new ClientServiceImpl(clientRepository, clientRepositoryConverterBean());
	}

	@Bean
	public GetAllClientsUseCaseImpl getAllClientsUseCaseBean() {
		return new GetAllClientsUseCaseImpl(clientServiceImplBean(), clientRestConverterBean());
	}

	@Bean
	public GetUserUseCaseImpl getUserUseCaseBean() {
		return new GetUserUseCaseImpl(userServiceImplBean(), getAllClientsUseCaseBean() );
	}
}