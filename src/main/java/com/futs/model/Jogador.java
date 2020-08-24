package com.futs.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(schema = "DB_FUTTS", name = "TB_JOGADOR")
public class Jogador {
    @Id
    @Column(name = "IDT", unique = true, nullable = false)
    private String idt;

    @Column(name = "IDTIME", unique = true, nullable = false)
    private Integer idTime;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "VERSAO", unique = true, nullable = false)
    private char versao;

    @Column(name = "INICIO_CONTRATO")
    private Date inicioContrato;

    @Column(name = "FIM_CONTRATO")
    private Date fimContrato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDTIME", referencedColumnName = "ID", insertable = false, updatable = false)
    private Time time;
}
