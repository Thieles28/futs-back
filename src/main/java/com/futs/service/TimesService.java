package com.futs.service;

import com.futs.model.Times;
import org.springframework.stereotype.Service;


@Service
public interface TimesService {

    Times atualizar(Times times, Long codigo);
    Times buscarTimesPeloCodigo(Long codigo);
}
