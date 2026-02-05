package com.arthur.ArthClinicaAPI.DTO.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PacienteReqDTO(
        @NotBlank(message = "O nome é obrigatório") String nome,
        @NotBlank(message = "O email é Obrigatório") @Email String email,
        @NotBlank(message = "O CPF é Obrigatório") String cpf
) {
}
