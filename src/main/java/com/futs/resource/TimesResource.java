package com.futs.resource;

import com.futs.model.Times;
import com.futs.repository.TimesRepository;
import com.futs.service.impl.TimesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("times")
public class TimesResource {

    @Autowired
    private TimesRepository timesRepository;

    @Autowired
    private TimesServiceImpl timesServiceImpl;

    @GetMapping
    public List<Times> listarTimes() {
        return timesRepository.findAll();
    }

    @GetMapping("{codigo}")
    public Times buscarTime(@PathVariable("codigo") Long codigo) {
        return timesRepository.findById(codigo).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Times> cadastrarTimes(@Valid @RequestBody Times times) {
         Times time = timesRepository.save(times);
         return ResponseEntity.status(HttpStatus.CREATED).body(time);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<Times> atualizarTimes(@PathVariable("codigo") Long codigo, @Valid @RequestBody Times times) {
        Times atualizar = timesServiceImpl.atualizar(times, codigo);
        return ResponseEntity.ok(atualizar);
    }

    @DeleteMapping("{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTimes(@PathVariable("codigo") Long codigo) {
        timesRepository.deleteById(codigo);
    }

}
