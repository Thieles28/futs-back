package com.futs.service.impl;

import com.futs.model.Campeonato;
import com.futs.repository.CampeonatoRepository;
import com.futs.service.CampeonatoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CampeonatoServiceImpl implements CampeonatoService {

    @Autowired
    CampeonatoRepository campeonatoRepository;

    @Override
    public List<Campeonato> listarTodosCampeonatos() {
        return campeonatoRepository.findAll();
    }

    @Override
    public Campeonato buscarCampeonatoPeloCodigo(Integer codigo) {
        Campeonato campeonatoSalvo = campeonatoRepository.findById(codigo).orElse(null);
        if (isNull(campeonatoSalvo)) {
            throw new EmptyResultDataAccessException(1);
        }
        return campeonatoSalvo;
    }

    @Override
    public ResponseEntity<Campeonato> cadastrarCampeonato(Campeonato campeonato) {
        Campeonato campeonatoSalvo = campeonatoRepository.save(campeonato);
        return ResponseEntity.status(HttpStatus.CREATED).body(campeonatoSalvo);
    }

    @Override
    public ResponseEntity<Campeonato> atualizarCampeonato(Integer codigo, Campeonato campeonato) {
        Campeonato campeonatoSalvo = buscarCampeonatoPeloCodigo(codigo);
        BeanUtils.copyProperties(campeonato, campeonatoSalvo, "codigoCampeonato");
        Campeonato save = campeonatoRepository.save(campeonatoSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @Override
    public void removerCampeonato(Integer codigo) {
        campeonatoRepository.deleteById(codigo);
    }
}
