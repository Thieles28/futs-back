package com.futs.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "DB_FUTTS_TESTE", name = "TB_CARTAO")
public class Cartao {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "IDJOGO")
    private Integer codigoJogo;

    @Column(name = "IDTJOGADOR")
    private Integer codigoJogador;

    @Column(name = "TIPO")
    private char tipo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDJOGO", referencedColumnName = "ID", insertable = false, updatable = false)
    private Jogo jogo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDTJOGADOR", referencedColumnName = "IDT", insertable = false, updatable = false)
    private Jogador jogador;

}
