package com.prueba_spring_boot.prueba_backend.infrastructure.persistence.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "client")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientEntity implements Serializable{

    private static final long serialVersionUID = -595183205195778907L;

    @Id
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