package com.futs.service.impl;

import com.futs.model.Times;
import com.futs.repository.TimesRepository;
import com.futs.service.TimesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import static java.util.Objects.isNull;

@Service
public class TimesServiceImpl implements TimesService {

    @Autowired
    private TimesRepository timesRepository;

    public Times atualizar(Times times, Long codigo) {
        Times timeSalvo = buscarTimesPeloCodigo(codigo);
        BeanUtils.copyProperties(times, timeSalvo, "codigo");
        return timesRepository.save(timeSalvo);
    }

    public Times buscarTimesPeloCodigo(Long codigo) {
        Times timeSalvo = timesRepository.findById(codigo).orElse(null);

        if (isNull(timeSalvo)) {
            throw new EmptyResultDataAccessException(1);
        }
        return timeSalvo;
    }
}
