package com.arthur.ArthClinicaAPI.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tab_paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
    private boolean ativo;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;
}
