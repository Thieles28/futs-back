package com.futs.service.impl;

import com.futs.model.Time;
import com.futs.repository.TimeRepository;
import com.futs.service.TimeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TimeServiceServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Override
    public List<Time> listarTodosTimes() {
        return timeRepository.findAll();
    }

    public Time buscarTimesPeloCodigo(Integer codigo) {
        Time timeSalvo = timeRepository.findById(codigo).orElse(null);

        if (isNull(timeSalvo)) {
            throw new EmptyResultDataAccessException(1);
        }
        return timeSalvo;
    }

    @Override
    public ResponseEntity<Time> cadastrarTimes(@RequestBody Time time) {
        Time respTime = timeRepository.save(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(respTime);
    }

    @Override
    public ResponseEntity<Time> atualizar(Integer codigo, Time time) {
        Time timeSalvo = buscarTimesPeloCodigo(codigo);
        BeanUtils.copyProperties(time, timeSalvo, "codigoTime");
        Time salvo = timeRepository.save(timeSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(salvo);
    }

    @Override
    public void removerTimes(Integer codigo) {
        timeRepository.deleteById(codigo);
    }
}
