package com.futs.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "times")
public class Times {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotEmpty
    @NotNull
    @Column(name = "nome")
    private String nome;

    @Column(name = "pontos")
    private Integer pontos;

    @Column(name = "jogos")
    private Integer jogos;

    @Column(name = "vitorias")
    private Integer vitorias;

    @Column(name = "empate")
    private Integer empate;

    @Column(name = "derrotas")
    private Integer derrotas;

    @Column(name = "gols_pro")
    private Integer golsPro;

    @Column(name = "gols_contra")
    private Integer golsContra;

    @Column(name = "saldo_gols")
    private Integer saldoGols;

    @Column(name = "aproveitamento")
    private Double aproveitamento;

    @Column(name = "cartao_amarelo")
    private String cartaoAmarelo;

    @Column(name = "cartao_vermelho")
    private String cartaoVermelho;

    @Column(name = "ultimos_jogos")
    private Integer ultimosJogos;

    @Column(name = "status")
    private String status;
}
