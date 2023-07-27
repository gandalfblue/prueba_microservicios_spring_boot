package com.prueba_spring_boot.prueba_backend.core.user;

import com.prueba_spring_boot.prueba_backend.core.shared.SelfValidating;
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
public class Client extends SelfValidating<Client> implements Serializable{

	private String id;

	@NotEmpty(message = "Campo primer nombre no puede ser vacío")
	@NotBlank(message = "Campo primer nombre no puede ser null")
	private String first_name;

	@NotEmpty(message = "Campo segundo nombre no puede ser vacío")
	@NotBlank(message = "Campo segundo nombre no puede ser nulo")
	private String second_name;

	@NotEmpty(message = "Campo primer apellido no puede ser vacío")
	@NotBlank(message = "Campo primer apellido no puede ser nulo")
	private String surname;

	@NotEmpty(message = "Campo segundo apellido no puede ser vacío")
	@NotBlank(message = "Campo segundo apellido no puede ser nulo")
	private String second_surname;

	@NotEmpty(message = "Campo ciudad de residencia no puede ser vacio")
	@NotBlank(message = "Campo ciudad de residencia no puede ser nulo")
	private String city_of_residence;

	@NotNull(message = "Campo telefono no puede ser nulo")
	private Long phone;

	@NotEmpty(message = "Campo direccion no puede ser vacio")
	@NotBlank(message = "Campo direccion no puede ser nulo")
	private String address;
}
