package com.futs.service;

import com.futs.model.Time;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TimesService {
    List<Time> listarTodosTimes();
    Time buscarTimesPeloCodigo(Long codigo);
    ResponseEntity<Time> cadastrarTimes(Time time);
    ResponseEntity<Time> atualizar(Long codigo, Time time);
    void removerTimes(Long codigo);
}
