package com.fiap.seguranca.service;

import com.fiap.seguranca.exception.RegistroNaoEncontrado;
import com.fiap.seguranca.models.Incidente;
import com.fiap.seguranca.repository.IncidenteRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IncidenteService {

    private final IncidenteRepository incidenteRepository;

    public IncidenteService(IncidenteRepository incidenteRepository){
        this.incidenteRepository = incidenteRepository;
    }

    public List<Incidente> listar(){
        return incidenteRepository.findAll();
    }

    public Incidente exibirPorId(@NotNull @Positive Long id){
        return incidenteRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public Incidente criar(@NotNull @Valid Incidente incidente){
        return incidenteRepository.save(incidente);
    }

    public Incidente atualizar(@NotNull @Positive Long id, @NotNull @Valid Incidente incidente){
        return incidenteRepository.findById(id).map(registroEncontrado -> {
            registroEncontrado.setTitulo(incidente.getTitulo());
            registroEncontrado.setDescricao(incidente.getDescricao());
            registroEncontrado.setLatitude(incidente.getLatitude());
            registroEncontrado.setLongitude(incidente.getLongitude());
            registroEncontrado.setDtAlteradoEm(new Date());
            return incidenteRepository.save(registroEncontrado);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void deletar(@NotNull @Positive Long id){
        incidenteRepository.delete(incidenteRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }
}
