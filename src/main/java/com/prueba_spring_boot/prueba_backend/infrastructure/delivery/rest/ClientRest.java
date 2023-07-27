package com.prueba_spring_boot.prueba_backend.infrastructure.delivery.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRest implements Serializable {

	private static final long serialVersionUID = -3599603517077196676L;

	private String id;

	@NotBlank
	@NotEmpty
	private String first_name;

	@NotBlank
	@NotEmpty
	private String second_name;

	@NotBlank
	@NotEmpty
	private String surname;

	@NotBlank
	@NotEmpty
	private String second_surname;

	@NotBlank
	@NotEmpty
	private String city_of_residence;

	@NotNull
	private Long phone;

	@NotBlank
	@NotEmpty
	private String address;
}
