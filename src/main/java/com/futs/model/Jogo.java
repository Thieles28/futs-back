package com.futs.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(schema = "DB_FUTTS", name = "TB_JOGO")
public class Jogo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoJogo;

    @Column(name = "IDCAMPEONATO")
    private Integer idCampeonato;

    @Column(name = "MANDANTE")
    private Integer mandante;

    @Column(name = "VISITANTE")
    private Integer visitante;

    @Column(name = "DATA")
    private Date data;

    @Column(name = "STATUS")
    private char status;

    @Column(name = "RODADAFASE")
    private char rodadafase;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCAMPEONATO", referencedColumnName = "ID", insertable = false, updatable = false)
    private Campeonato campeonato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MANDANTE", referencedColumnName = "ID", insertable = false, updatable = false)
    private Time timeMandante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VISITANTE", referencedColumnName = "ID", insertable = false, updatable = false)
    private Time timeVisitante;
}
