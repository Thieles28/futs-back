package com.futs.service;

import com.futs.model.Time;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TimeService {
    List<Time> listarTodosTimes();
    Time buscarTimesPeloCodigo(Integer codigo);
    ResponseEntity<Time> cadastrarTimes(Time time);
    ResponseEntity<Time> atualizar(Integer codigo, Time time);
    void removerTimes(Integer codigo);
}
