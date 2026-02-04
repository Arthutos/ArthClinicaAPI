package com.arthur.ArthClinicaAPI.Entity;

import com.arthur.ArthClinicaAPI.utils.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tab_consultas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalDate horaFim;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;
}
