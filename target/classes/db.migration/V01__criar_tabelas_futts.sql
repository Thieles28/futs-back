CREATE TABLE IF NOT EXISTS TB_CAMPEONATO (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(60) NOT NULL,
  CONSTRAINT PK_ID PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS TB_TIME (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(60) NOT NULL,
  CONSTRAINT PK_ID PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS TB_JOGADOR (
  IDT VARCHAR(11) NOT NULL,
  IDTIME INT(11) NOT NULL,
  NOME VARCHAR(60) NOT NULL,
  VERSAO CHAR(1) NOT NULL,
  INICIO_CONTRATO DATE NOT NULL,
  FIM_CONTRATO DATE,
  CONSTRAINT PK_IDT PRIMARY KEY(IDT, IDTIME, VERSAO),
  CONSTRAINT FK_TIME_JOGA FOREIGN KEY(IDTIME) REFERENCES TB_TIME(ID)
);

CREATE TABLE IF NOT EXISTS TB_JOGO (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  IDCAMPEONATO INT(11) NOT NULL,
  MANDANTE INT(11) NOT NULL,
  VISITANTE INT(11) NOT NULL,
  DATA DATETIME NOT NULL,
  STATUS CHAR(1) NOT NULL DEFAULT 'A',
  RODADAFASE CHAR(2) NOT NULL,
  CONSTRAINT PK_ID PRIMARY KEY(ID),
  CONSTRAINT FK_CAMP_JOGO FOREIGN KEY(IDCAMPEONATO) REFERENCES TB_CAMPEONATO(ID),
  CONSTRAINT FK_TIME_JOGO_M FOREIGN KEY(MANDANTE) REFERENCES TB_TIME(ID),
  CONSTRAINT FK_TIME_JOGO_V FOREIGN KEY(VISITANTE) REFERENCES TB_TIME(ID)
);

/*STATUS jogos em andamento(A), encerrado(E), folga(F)*/

CREATE TABLE IF NOT EXISTS TB_GOL (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  IDJOGO INT(11) NOT NULL,
  IDTJOGADOR VARCHAR(11) NOT NULL,
  CONSTRAINT PK_ID PRIMARY KEY(ID),
  CONSTRAINT FK_JOGO_GOL FOREIGN KEY(IDJOGO) REFERENCES TB_JOGO(ID),
  CONSTRAINT FK_JOGA_GOL FOREIGN KEY(IDTJOGADOR) REFERENCES TB_JOGADOR(IDT)
);

CREATE TABLE IF NOT EXISTS TB_CARTAO (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  IDJOGO INT(11) NOT NULL,
  IDTJOGADOR VARCHAR(11) NOT NULL,
  TIPO CHAR(1) NOT NULL,
  CONSTRAINT PK_ID PRIMARY KEY(ID),
  CONSTRAINT FK_JOGO_CART FOREIGN KEY(IDJOGO) REFERENCES TB_JOGO(ID),
  CONSTRAINT FK_JOGA_CART FOREIGN KEY(IDTJOGADOR) REFERENCES TB_JOGADOR(IDT),
  CONSTRAINT CK_CART_TIPO CHECK (TIPO IN ('A','V'))
);