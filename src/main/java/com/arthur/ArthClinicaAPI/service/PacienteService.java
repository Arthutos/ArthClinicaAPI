package com.arthur.ArthClinicaAPI.service;

import com.arthur.ArthClinicaAPI.DTO.Cliente.PacienteReqDTO;
import com.arthur.ArthClinicaAPI.DTO.Cliente.PacienteResDTO;
import com.arthur.ArthClinicaAPI.Entity.Paciente;
import com.arthur.ArthClinicaAPI.Repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService
{
    @Autowired
    private PacienteRepository pacienteRepository;

    public ResponseEntity<List<PacienteResDTO>> findAllPacientes()
    {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteResDTO> data = pacientes
                .stream().map(p -> new PacienteResDTO(p.getId(), p.getNome(), p.getEmail(), p.getCpf(), p.isAtivo(), p.getConsultas()))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    public ResponseEntity<PacienteResDTO> findPaciente(long id)
    {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Este paciente não existe no sistema"));
        PacienteResDTO data = new PacienteResDTO(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.isAtivo(), paciente.getConsultas());
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @Transactional
    public ResponseEntity<PacienteResDTO> createPaciente(PacienteReqDTO req)
    {
        Paciente paciente = new Paciente();
        paciente.setNome(req.nome());
        paciente.setCpf(req.cpf());
        paciente.setEmail(req.email());
        paciente.setAtivo(true);
        pacienteRepository.save(paciente);

        PacienteResDTO res = new PacienteResDTO(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.isAtivo(), paciente.getConsultas());
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @Transactional
    public ResponseEntity<PacienteResDTO> updatePaciente(long id, PacienteReqDTO req)
    {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Este paciente não existe no sistema"));
        paciente.setNome(req.nome());
        paciente.setCpf(req.cpf());
        paciente.setEmail(req.email());
        pacienteRepository.save(paciente);

        PacienteResDTO res = new PacienteResDTO(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.isAtivo(), paciente.getConsultas());
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @Transactional
    public ResponseEntity<String> desativarPaciente(long id)
    {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não Encontrado"));
        if(paciente.isAtivo() == false)
        {
            throw new RuntimeException("O paciente já está Desativado!");
        }
        paciente.setAtivo(false);
        pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.OK).body("o paciente: " + paciente.getNome() + " foi desativado do sistema");
    }

    @Transactional
    public ResponseEntity<String> ativarPaciente(long id)
    {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não Encontrado"));
        if(paciente.isAtivo() == true)
        {
            throw new RuntimeException("O paciente já está Ativo");
        }
        paciente.setAtivo(true);
        pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.OK).body("o paciente: " + paciente.getNome() + " foi desativado do sistema");
    }

    @Transactional
    public ResponseEntity<String> excluirPaciente(long id)
    {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        if(paciente.isAtivo() == true)
        {
            throw new RuntimeException("Este paciente está ativo! não é possivel deleta-lo");
        }
        pacienteRepository.delete(paciente);
        return ResponseEntity.status(HttpStatus.OK).body("O paciente foi excluído do sistema");
    }
}
