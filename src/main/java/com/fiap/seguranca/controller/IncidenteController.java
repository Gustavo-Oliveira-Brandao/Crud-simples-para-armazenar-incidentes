package com.fiap.seguranca.controller;


import com.fiap.seguranca.models.Incidente;
import com.fiap.seguranca.service.IncidenteService;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidentes")
@Validated
public class IncidenteController {

    private final IncidenteService incidenteService;

    public IncidenteController(IncidenteService incidenteService){
        this.incidenteService = incidenteService;
    }

    @GetMapping
    public List<Incidente> listar(){
        return incidenteService.listar();
    }

    @GetMapping("/{id}")
    public Incidente exibirPorId(@PathVariable @NotNull @Positive Long id){
        return incidenteService.exibirPorId(id);
    }

    @PostMapping
    public Incidente criar(@RequestBody @NotNull @Valid Incidente incidente){
        return incidenteService.criar(incidente);
    }

    @PutMapping("/{id}")
    public Incidente atualizar(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid Incidente incidente){
        return incidenteService.atualizar(id, incidente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable @NotNull @Positive Long id){
        incidenteService.deletar(id);
    }
}
