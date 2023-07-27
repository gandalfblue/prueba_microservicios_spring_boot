package com.prueba_spring_boot.prueba_backend.infrastructure.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity implements Serializable{

    private static final long serialVersionUID = -595183205195778907L;

    @Id
    private String id;

    @NotBlank
    @NotEmpty
    private String type;

    @Indexed(unique = true)
    @NumberFormat
    @NotNull
    private Integer documentNumber;
}