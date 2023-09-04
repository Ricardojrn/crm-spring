package org.myproject.crm.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.myproject.crm.dtos.validations.Cpf;

@Data
public class ClientInputDTO {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Cpf
    private String cpf;
}
