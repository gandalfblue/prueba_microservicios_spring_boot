package com.prueba_spring_boot.prueba_backend.infrastructure.delivery.impl;

import com.prueba_spring_boot.prueba_backend.core.user.use_cases.GetUserUseCaseImpl;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.UserController;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.converters.UserRestConverter;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.responses.UserResponse;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.ClientRest;
import com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest.UserRest;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.constants.CommonConstants;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.constants.RestConstants;
import com.prueba_spring_boot.prueba_backend.infrastructure.shared.exceptions.UserException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_USER)
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

	private final GetUserUseCaseImpl getUserUseCaseImpl;
	private final UserRestConverter userRestConverter;

	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/getAllClients")
	@Operation(summary = "Get a all clients")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Founds the users",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = ClientRest.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied",
					content = @Content),
			@ApiResponse(responseCode = "404", description = "User not found",
					content = @Content) })
	public Flux<UserResponse<ClientRest>> getAllClients(UserRest userRest) throws UserException {
		return getUserUseCaseImpl.execute(userRestConverter.mapToEntity(userRest)).
				flatMap(userRestResponse -> Flux.just(new UserResponse<>(CommonConstants.SUCCESS,
						String.valueOf(HttpStatus.OK), CommonConstants.OK, userRestResponse)))
				.onErrorResume(error -> {
					if(error.getMessage().split(" ")[0].equals("404")){
						return Mono.just(new UserResponse<>(CommonConstants.FAIL,
								String.valueOf(HttpStatus.NOT_FOUND), "User don't exist"));
					} else if (error.getMessage().split(" ")[0].equals("400")){
						return Mono.just(new UserResponse<>(CommonConstants.FAIL,
								String.valueOf(HttpStatus.BAD_REQUEST), "Error, Type not supported"));
					}
					return Mono.just(new UserResponse<>(CommonConstants.FAIL,
							String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), "Server error, could not connect"));
				});
	}
}
