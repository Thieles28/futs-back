package com.futs.service.impl;

import com.futs.model.Time;
import com.futs.repository.TimesRepository;
import com.futs.service.TimesService;
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
public class TimesServiceImpl implements TimesService {

    @Autowired
    private TimesRepository timesRepository;

    @Override
    public List<Time> listarTodosTimes() {
        return timesRepository.findAll();
    }

    public Time buscarTimesPeloCodigo(Long codigo) {
        Time timeSalvo = timesRepository.findById(codigo).orElse(null);

        if (isNull(timeSalvo)) {
            throw new EmptyResultDataAccessException(1);
        }
        return timeSalvo;
    }

    @Override
    public ResponseEntity<Time> cadastrarTimes(@RequestBody Time time) {
        Time respTime = timesRepository.save(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(respTime);
    }

    @Override
    public ResponseEntity<Time> atualizar(Long codigo, Time time) {
        Time timeSalvo = buscarTimesPeloCodigo(codigo);
        BeanUtils.copyProperties(time, timeSalvo, "codigo");
        Time salvo = timesRepository.save(timeSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(salvo);
    }

    @Override
    public void removerTimes(Long codigo) {
        timesRepository.deleteById(codigo);
    }
}
