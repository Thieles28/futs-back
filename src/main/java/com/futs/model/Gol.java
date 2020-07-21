package com.futs.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "DB_FUTTS_TESTE",name = "TB_GOL")
public class Gol {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long codigo;

    @Column(name = "IDJOGO")
    private Integer codigoIdJogo;

    @Column(name = "IDTJOGADOR")
    private String codigoJogador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDJOGO", referencedColumnName = "ID", insertable = false, updatable = false)
    private Jogo jogo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDTJOGADOR", referencedColumnName = "IDT", insertable = false, updatable = false)
    private Jogador jogador;

}
