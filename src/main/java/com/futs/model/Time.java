package com.futs.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(schema = "DB_FUTTS", name = "TB_TIME")
public class Time {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoTime;

    @NotEmpty
    @NotNull
    @Column(name = "NOME")
    private String nome;

//    @NotEmpty
//    @NotNull
//    @Column(name = "nome")
//    private String nome;
//
//    @Column(name = "pontos")
//    private Integer pontos;
//
//    @Column(name = "jogos")
//    private Integer jogos;
//
//    @Column(name = "vitorias")
//    private Integer vitorias;
//
//    @Column(name = "empate")
//    private Integer empate;
//
//    @Column(name = "derrotas")
//    private Integer derrotas;
//
//    @Column(name = "gols_pro")
//    private Integer golsPro;
//
//    @Column(name = "gols_contra")
//    private Integer golsContra;
//
//    @Column(name = "saldo_gols")
//    private Integer saldoGols;
//
//    @Column(name = "aproveitamento")
//    private Double aproveitamento;
//
//    @Column(name = "cartao_amarelo")
//    private String cartaoAmarelo;
//
//    @Column(name = "cartao_vermelho")
//    private String cartaoVermelho;
//
//    @Column(name = "ultimos_jogos")
//    private Integer ultimosJogos;
//
//    @Column(name = "status")
//    private String status;
}
