package com.prueba_spring_boot.prueba_backend.core.user.use_cases;

import com.prueba_spring_boot.prueba_backend.core.user.Client;
import com.prueba_spring_boot.prueba_backend.core.user.User;
import com.prueba_spring_boot.prueba_backend.core.user.ports.ClientRepositoryService;
import com.prueba_spring_boot.prueba_backend.core.user.ports.UserRepositoryService;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.converters.ClientRestConverter;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.ClientRest;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.impl.UserServiceImpl;
import com.prueba_spring_boot.prueba_backend.infrastructure.persistence.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetUserUseCaseImplTest {

    @Autowired
    private GetAllClientsUseCaseImpl getAllClientsUseCase;

    @Autowired
    private ClientRepositoryService clientRepositoryService;

    @Autowired
    private ClientRestConverter clientRestConverter;

    @Autowired
    private GetUserUseCaseImpl getUserUseCase;

    @Autowired
    private UserRepositoryService userRepository;

    private static final String ID_USER = "U-0001";
    private static final String TYPE = "C";
    private static final Integer DOCUMENT_NUMBER = 987654321;
    private static final String ID_CLIENT = "U-0001";
    private static final String FIRST_NAME_CLIENT = "Andres";
    private static final String SECOND_NAME_CLIENT = "Felipe";
    private static final String SURNAME_CLIENT = "Lozada";
    private static final String SECOND_SURNAME_CLIENT = "Andrade";
    private static final String CITY_OF_RESIDENCE_CLIENT = "Madrid";
    private static final Long PHONE_CLIENT = 123456789L;
    private static final String ADDRESS_CLIENT = "Av siempre viva 123";
    @BeforeEach
    void configurationInitial() {
        clientRepositoryService = mock(ClientRepositoryService.class);
        userRepository = mock(UserRepositoryService.class);
        getAllClientsUseCase = new GetAllClientsUseCaseImpl(clientRepositoryService, clientRestConverter);
        getUserUseCase = new GetUserUseCaseImpl(userRepository, getAllClientsUseCase);
    }

    @Test
    void executeTest() {

        var user = new User();
        user.setId(ID_USER);
        user.setType(TYPE);
        user.setDocumentNumber(DOCUMENT_NUMBER);

        var client = new Client();
        client.setId(ID_CLIENT);
        client.setFirst_name(FIRST_NAME_CLIENT);
        client.setSecond_name(SECOND_NAME_CLIENT);
        client.setSurname(SURNAME_CLIENT);
        client.setSecond_surname(SECOND_SURNAME_CLIENT);
        client.setCity_of_residence(CITY_OF_RESIDENCE_CLIENT);
        client.setPhone(PHONE_CLIENT);
        client.setAddress(ADDRESS_CLIENT);

        var clientRest = new ClientRest();
        clientRest.setId(ID_CLIENT);
        clientRest.setFirst_name(FIRST_NAME_CLIENT);
        clientRest.setSecond_name(SECOND_NAME_CLIENT);
        clientRest.setSurname(SURNAME_CLIENT);
        clientRest.setSecond_surname(SECOND_SURNAME_CLIENT);
        clientRest.setCity_of_residence(CITY_OF_RESIDENCE_CLIENT);
        clientRest.setPhone(PHONE_CLIENT);
        clientRest.setAddress(ADDRESS_CLIENT);

        when(userRepository.validateTypeDocument(Mockito.any(User.class))).thenReturn(Mono.just(Boolean.class).hasElement());
        when(clientRepositoryService.getAllClients()).thenReturn(Flux.just(client));

        StepVerifier.create(getUserUseCase.execute(user))
                .expectNextMatches(clientResponse -> {
                    assert clientResponse.getId().equalsIgnoreCase(clientRest.getId());
                    assert clientResponse.getFirst_name().equalsIgnoreCase(clientRest.getFirst_name());
                    assert clientResponse.getSecond_name().equalsIgnoreCase(clientRest.getSecond_name());
                    assert clientResponse.getSurname().equalsIgnoreCase(clientRest.getSurname());
                    assert clientResponse.getSecond_surname().equalsIgnoreCase(clientRest.getSecond_surname());
                    assert clientResponse.getCity_of_residence().equals(clientRest.getCity_of_residence());
                    assert clientResponse.getPhone().equals(clientRest.getPhone());
                    assert clientResponse.getAddress().equals(clientRest.getAddress());
                    return true;
                })
                .verifyComplete();

        verify(clientRepositoryService).getAllClients();
    }
}