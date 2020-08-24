package com.futs.resource;

import com.futs.model.Campeonato;
import com.futs.service.impl.CampeonatoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("campeonatos")
public class CampeonatoResource {

        @Autowired
        private CampeonatoServiceImpl CampeonatoServiceImpl;

        @ApiOperation("Listagem de todos campeonatos")
        @GetMapping
        public List<Campeonato> buscaTodosCampeonatos() {
            return CampeonatoServiceImpl.listarTodosCampeonatos();
        }

        @ApiOperation("Obtem um único campeonato")
        @GetMapping("{codigo}")
        public Campeonato obtemUnicoCampeonato(@PathVariable("codigo") Integer codigo) {
            return CampeonatoServiceImpl.buscarCampeonatoPeloCodigo(codigo);
        }

        @ApiOperation("Cadastrar campeonato")
        @PostMapping
        public ResponseEntity<Campeonato> cadastrarCampeonato(@Valid @RequestBody Campeonato campeonato) {
                return CampeonatoServiceImpl.cadastrarCampeonato(campeonato);
        }

        @ApiOperation("Atualizar campeonato")
        @PutMapping("{codigo}")
        public ResponseEntity<Campeonato> atualizarCampeonato(@PathVariable("codigo") Integer codigo, @Valid @RequestBody Campeonato campeonato) {
                return CampeonatoServiceImpl.atualizarCampeonato(codigo, campeonato);
        }

        @ApiOperation("Remove um campeonato")
        @DeleteMapping("{codigo}")
        public void removerCampeonato(@PathVariable("codigo") Integer codigo) {
                CampeonatoServiceImpl.removerCampeonato(codigo);
        }

}
