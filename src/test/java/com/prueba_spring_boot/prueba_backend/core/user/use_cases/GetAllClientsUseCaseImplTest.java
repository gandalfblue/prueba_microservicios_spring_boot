package com.prueba_spring_boot.prueba_backend.core.user.use_cases;

import com.prueba_spring_boot.prueba_backend.core.user.Client;
import com.prueba_spring_boot.prueba_backend.core.user.ports.ClientRepositoryService;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.converters.ClientRestConverter;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.ClientRest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetAllClientsUseCaseImplTest {

    @Autowired
    private ClientRepositoryService clientRepositoryService;

    @Autowired
    private ClientRestConverter clientRestConverter;

    @Autowired
    private GetAllClientsUseCaseImpl getAllClientsUseCase;

    private static final String ID = "U-0001";
    private static final String FIRTS_NAME = "Andres";
    private static final String SECOND_NAME = "Felipe";
    private static final String SURNAME = "Lozada";
    private static final String SECOND_SURNAME = "Andrade";
    private static final String CITY_OF_RESIDENCE = "Madrid";
    private static final Long PHONE = 123456789L;
    private static final String ADDRESS = "Av siempre viva 123";

    @BeforeEach
    void configurationInitial() {
        clientRepositoryService = mock(ClientRepositoryService.class);
        getAllClientsUseCase = new GetAllClientsUseCaseImpl(clientRepositoryService, clientRestConverter);
    }

    @Test
    void executeTest() {

        var client = new Client();
        client.setId(ID);
        client.setFirst_name(FIRTS_NAME);
        client.setSecond_name(SECOND_NAME);
        client.setSurname(SURNAME);
        client.setSecond_surname(SECOND_SURNAME);
        client.setCity_of_residence(CITY_OF_RESIDENCE);
        client.setPhone(PHONE);
        client.setAddress(ADDRESS);

        var clientRest = new ClientRest();
        clientRest.setId(ID);
        clientRest.setFirst_name(FIRTS_NAME);
        clientRest.setSecond_name(SECOND_NAME);
        clientRest.setSurname(SURNAME);
        clientRest.setSecond_surname(SECOND_SURNAME);
        clientRest.setCity_of_residence(CITY_OF_RESIDENCE);
        clientRest.setPhone(PHONE);
        clientRest.setAddress(ADDRESS);


        when(clientRepositoryService.getAllClients()).thenReturn(Flux.just(client));

        StepVerifier.create(getAllClientsUseCase.execute())
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