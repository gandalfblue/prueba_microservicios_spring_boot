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
public class User extends SelfValidating<User> implements Serializable{

	private String id;

	@NotEmpty(message = "Campo type no puede ser vacío")
	@NotBlank(message = "Campo type no puede ser null")
	private String type;

	@NotNull(message = "Campo numero de documento no puede ser vacío")
	private Integer documentNumber;
}
