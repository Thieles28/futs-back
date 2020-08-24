package com.futs.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "DB_FUTTS", name = "TB_GOL")
public class Gol {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoGol;

    @Column(name = "IDJOGO", unique = true, nullable = false)
    private Integer idJogo;

    @Column(name = "IDTJOGADOR", unique = true, nullable = false)
    private String idtJogador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDJOGO", referencedColumnName = "ID", insertable = false, updatable = false)
    private Jogo jogo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDTJOGADOR", referencedColumnName = "IDT", insertable = false, updatable = false)
    private Jogador jogador;

}
