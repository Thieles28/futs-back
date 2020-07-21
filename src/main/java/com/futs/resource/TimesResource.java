package com.futs.resource;

import com.futs.model.Time;
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
    private TimesServiceImpl timesServiceImpl;

    @GetMapping
    public List<Time> listarTimes() {
        return timesServiceImpl.listarTodosTimes();
    }

    @GetMapping("{codigo}")
    public Time buscarTime(@PathVariable("codigo") Long codigo) {
        return timesServiceImpl.buscarTimesPeloCodigo(codigo);
    }

    @PostMapping
    public ResponseEntity<Time> cadastrarTimes(@Valid @RequestBody Time time) {
         return timesServiceImpl.cadastrarTimes(time);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<Time> atualizarTimes(@PathVariable("codigo") Long codigo, @Valid @RequestBody Time time) {
        return timesServiceImpl.atualizar(codigo, time);
    }

    @DeleteMapping("{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTimes(@PathVariable("codigo") Long codigo) {
        timesServiceImpl.removerTimes(codigo);
    }

}
