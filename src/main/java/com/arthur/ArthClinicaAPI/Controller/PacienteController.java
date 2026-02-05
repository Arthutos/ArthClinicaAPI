package com.arthur.ArthClinicaAPI.Controller;

import com.arthur.ArthClinicaAPI.DTO.Cliente.PacienteReqDTO;
import com.arthur.ArthClinicaAPI.DTO.Cliente.PacienteResDTO;
import com.arthur.ArthClinicaAPI.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class PacienteController
{

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteResDTO>> listarPacientes()
    {
        return pacienteService.findAllPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResDTO> obterPaciente(@PathVariable long id)
    {
        return pacienteService.findPaciente(id);
    }

    @PostMapping
    public ResponseEntity<PacienteResDTO> criarPaciente(@RequestBody @Valid PacienteReqDTO req)
    {
        return pacienteService.createPaciente(req);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResDTO> atualizarPaciente(@PathVariable long id, @RequestBody @Valid PacienteReqDTO req)
    {
        return pacienteService.updatePaciente(id, req);
    }

    @PutMapping("/des/{id}")
    public ResponseEntity<String> desativar(@PathVariable long id)
    {
        return pacienteService.desativarPaciente(id);
    }

    @PutMapping("/at/{id}")
    public ResponseEntity<String> ativar(@PathVariable long id)
    {
        return pacienteService.ativarPaciente(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable long id)
    {
        return pacienteService.excluirPaciente(id);
    }
}
