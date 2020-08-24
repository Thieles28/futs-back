package com.futs.resource;

import com.futs.model.Time;
import com.futs.service.impl.TimeServiceServiceImpl;
import io.swagger.annotations.ApiOperation;
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
    private TimeServiceServiceImpl timeServiceServiceImpl;

    @ApiOperation("Listar todos os times")
    @GetMapping
    public List<Time> listarTimes() {
        return timeServiceServiceImpl.listarTodosTimes();
    }

    @ApiOperation("Obter um único time")
    @GetMapping("{codigo}")
    public Time buscarTime(@PathVariable("codigo") Integer codigo) {
        return timeServiceServiceImpl.buscarTimesPeloCodigo(codigo);
    }

    @ApiOperation("Cadastar times")
    @PostMapping
    public ResponseEntity<Time> cadastrarTimes(@Valid @RequestBody Time time) {
         return timeServiceServiceImpl.cadastrarTimes(time);
    }

    @ApiOperation("Atualizar times")
    @PutMapping("{codigo}")
    public ResponseEntity<Time> atualizarTimes(@PathVariable("codigo") Integer codigo, @Valid @RequestBody Time time) {
        return timeServiceServiceImpl.atualizar(codigo, time);
    }

    @ApiOperation("Remover times")
    @DeleteMapping("{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTimes(@PathVariable("codigo") Integer codigo) {
        timeServiceServiceImpl.removerTimes(codigo);
    }

}
