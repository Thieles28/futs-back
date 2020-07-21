package com.futs.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(schema = "DB_FUTTS_TESTE", name = "TB_JOGADOR")
public class Jogador {

    @Id
    @Column(name = "IDT")
    private String IDT;

    @Column(name = "IDTIME")
    private Integer codigoTime;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "VERSAO")
    private char versao;

    @Column(name = "INICIO_CONTRATO")
    private Date inicioContrato;

    @Column(name = "FIM_CONTRATO")
    private Date fimContrato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDTIME", referencedColumnName = "ID", insertable = false, updatable = false)
    private Time time;

}
