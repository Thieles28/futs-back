package com.futs.service;

import com.futs.model.Campeonato;
import com.futs.model.Time;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CampeonatoService {
    List<Campeonato> listarTodosCampeonatos();
    Campeonato buscarCampeonatoPeloCodigo(Integer codigo);
    ResponseEntity<Campeonato> cadastrarCampeonato(Campeonato campeonato);
    ResponseEntity<Campeonato> atualizarCampeonato(Integer codigo, Campeonato campeonato);
    void removerCampeonato(Integer codigo);
}
