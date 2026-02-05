package com.arthur.ArthClinicaAPI.DTO.Cliente;

import com.arthur.ArthClinicaAPI.Entity.Consulta;

import java.util.List;

public record PacienteResDTO(
        long id,
        String name,
        String email,
        String cpf,
        boolean ativo,
        List<Consulta> consultas
) {
}
