/*DDL*/
DROP SCHEMA CentroEstetico;
CREATE SCHEMA CentroEstetico;
USE CentroEstetico;

CREATE TABLE Cliente(
  CodiceCliente int PRIMARY KEY AUTO_INCREMENT,
  Nome VARCHAR(25) NOT NULL,
  Cognome VARCHAR(25) NOT NULL,
  Eta INT NOT NULL,
  Sesso CHAR(1) NOT NULL CHECK(Sesso IN('M','F'))
);

CREATE TABLE Estetista(
  CodiceFiscale char(16) PRIMARY KEY,
  Nome varchar(25) NOT NULL,
  Cognome varchar(25) NOT NULL,
  DataTerminazione DATE,
  Stipendio  double NOT NULL,
  GiorniLavorativi int NOT NULL,
  TipoContratto varchar(25) NOT NULL,
  Tipo varchar(25) NOT NULL CHECK(Tipo IN('SPECIALIZZATA','NON SPECIALIZZATA')),
  DataAssunzione DATE NOT NULL,
  OrarioInizio TIME NOT NULL,
  OrarioFine TIME NOT NULL,
  OreStraordinarie TIME DEFAULT '00:00:00' NOT NULL,
  Eta int NOT NULL,
  Specializzazione varchar(25),
  OreTotali TIME
  
);

CREATE TABLE Sala(
  CodiceSala char(4) PRIMARY KEY,
  Nome varchar(25) NOT NULL,
  MetriQuadri float NOT NULL
);
 
CREATE TABLE Macchinario(
  Tipo VARCHAR(15) NOT NULL CHECK(Tipo IN('VISO','CORPO')),
  Descrizione VARCHAR(100),
  Nome VARCHAR(25) NOT NULL,
  Modello VARCHAR(25),
  Marca VARCHAR(25),
  Dimagrimento CHAR(2) CHECK(Dimagrimento IN('SI','NO')),
  Antinvecchiamento CHAR(2) CHECK(Antinvecchiamento IN('SI','NO')),
  PRIMARY KEY (Modello,Marca)
);

CREATE TABLE Appuntamento(
  CodiceCliente int, 
  foreign KEY(CodiceCliente) REFERENCES Cliente(CodiceCliente)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  Durata TIME NOT NULL,
  Descrizione VARCHAR(100),
  Tipo VARCHAR(15) NOT NULL CHECK (Tipo IN ('VISO','CORPO','NESSUNO')),
  Data DATE NOT NULL,
  Ora TIME NOT NULL,
  CodiceFiscale CHAR(16) NOT NULL,
  foreign KEY(CodiceFiscale) REFERENCES Estetista(CodiceFiscale)
     ON UPDATE CASCADE
     ON DELETE CASCADE,
  Modello varchar(25),
  Marca varchar(25),
  foreign KEY(Modello,Marca) REFERENCES Macchinario(Modello,Marca)
    ON UPDATE cascade
    ON DELETE cascade,
  CodiceSala char(4) NOT NULL,
  foreign KEY(CodiceSala) REFERENCES Sala(CodiceSala)
    ON UPDATE cascade
    ON DELETE cascade,
  TempoUtilizzo TIME,
  PRIMARY KEY(Data,Ora,CodiceCliente)
);

CREATE TABLE Impiego(
  CodiceFiscale char(16),
  Modello varchar(25),
  Marca varchar(25),
  PRIMARY KEY (CodiceFiscale,Modello,Marca),
  foreign KEY(Modello,Marca) REFERENCES Macchinario(Modello,Marca)
    ON UPDATE cascade
    ON DELETE cascade,
  foreign KEY(CodiceFiscale) REFERENCES Estetista(CodiceFiscale)
    ON UPDATE cascade
    ON DELETE cascade
);

CREATE TABLE Locazione(
  Modello varchar(25),
  Marca varchar(25),
  CodiceSala char(4),
  PRIMARY KEY (Modello,Marca,CodiceSala),
  foreign KEY(CodiceSala) REFERENCES Sala(CodiceSala)
    ON UPDATE cascade
    ON DELETE cascade,
  foreign KEY(Modello,Marca) REFERENCES Macchinario(Modello,Marca)
    ON UPDATE cascade
    ON DELETE cascade
);

/*DML*/
USE centroestetico;

INSERT INTO Cliente(Nome,Cognome,Eta,Sesso,CodiceCliente) VALUES
    ('Carmela','Castrini',52,'F',1),
    ('Tina','Varanelli',82,'F',2),
    ('Sibilla','Topazzi',86,'F',3),
    ('Ansaldo','Bezzini',83,'M',4),
    ('Costante','Sonvico',20,'M',5),
    ('Tamara','Zito',83,'F',6),
    ('Settimio','Trevisano',39,'M',7),
    ('Aldo','Trevisano',39,'M',8),
    ('Aldo','Zito',25,'M',10),
    ('Maria','Rossi',45,'F',11),
    ('Mario','Rossi',47,'M',12),
    ('Giovanni','Luca',19,'M',13),
    ('Francesca','Laudo',54,'F',14),
    ('Luca','Treviso',65,'M',15),
    ('Cesare','Aceto',45,'M',16),
    ('Biagio','Centro',19,'M',17),
    ('Luana','Stabile',25,'F',18),
    ('Stefano','Vivo',27,'M',19),
    ('Diana','Tepore',22,'F',20);

INSERT INTO Estetista (Nome,Cognome,DataTerminazione,Stipendio,GiorniLavorativi,TipoContratto,Tipo,DataAssunzione,CodiceFiscale,Eta,OrarioInizio,OrarioFine,Specializzazione,OreTotali,OreStraordinarie) VALUES
    ('Eliana','Fioranelli',NULL,800,22,'Indeterminato','SPECIALIZZATA','2017-10-22','FRNLNE97R48I480O',21,'08:00','15:00','Pulizia viso','01:30','01:00:00'),
    ('Eugenia','Marturelli',NULL,1200,22,'Indeterminato','SPECIALIZZATA','2012-10-01','MRTGNE97T48I495B',21,'08:00','15:00','Puliziaviso','02:30','02:40:00'),
    ('Milena','Pongolini',NULL,500,16,'Part-Time','NON SPECIALIZZATA','2016-05-06','PNGMLN00E66I696I',18,'14:00','20:00',NULL,NULL,'01:30:00'),
    ('Rosaria','Stefanoni',NULL,700,20,'Indeterminato','NON SPECIALIZZATA','2018-08-19','STFRSR97M59I470F',21,'15:00','20:00',NULL,NULL,'01:40:00'),
    ('Cloe','Cittarello',NULL,1000,22,'Indeterminato','NON SPECIALIZZATA','2017-03-07','CTTCLO94C47I400X',24,'15:00','20:00',NULL,NULL,'03:00:00'),
    ('Amalia','Baliotti','2018/08/15',1100,20,'Indeterminato','NON SPECIALIZZATA','2016-12-08','BLTMLA90D60H879A',28,'09:00','15:00',NULL,NULL,'01:20:00'),
    ('Arabella','Benaggia',NULL,1100,20,'Indeterminato','SPECIALIZZATA','2016-06-17','BNGRLL91P51H987N',27,'09:00','15:00','Lampade','04:15','09:50:00'),
    ('Debora','Danovara','2018/11/28',700,16,'Part-Time','NON SPECIALIZZATA','2016-05-15','DNVDBR99L61I629G',19,'09:00','15:00',NULL,NULL,'04:00:00'),
    ('Milena','Stefanoni',NULL,1200,15,'Indeterminato','SPECIALIZZATA','2016-02-15','CYVRCK65L03D928R',25,'08:00','16:00','Massaggi','01:20','06:00:00');

INSERT INTO Macchinario (Tipo,Descrizione,Nome,Modello,Marca,Dimagrimento,Antinvecchiamento) VALUES
    ('VISO',NULL,'radiofrequenza','796','ASDF',NULL,'SI'),
    ('CORPO',NULL,'Lampada Cromo terapia','phyllotaxis','Decomedical','NO',NULL),
    ('CORPO',NULL,'Luce Pulsata','IPL 10000+ SalonPro','Beurer','NO',NULL),
    ('CORPO',NULL,'Ultrasuoni','CAVISLIM PLUS YS35','Tecnovita','SI',NULL),
    ('VISO','Sauna facciale','Vapore','FS 50','Beurer',NULL,'SI');

INSERT INTO Sala (Nome,MetriQuadri,CodiceSala) VALUES
    ('Sole',40,'A1'),
    ('Luna',50,'A2'),
    ('Marte',60,'A3'),
    ('Giove',25,'A4'),
    ('Saturno',50,'A5'),
    ('Venere',25,'A6'),
    ('Nettuno',35,'B1'),
    ('Terra',45,'B2'),
    ('Mercurio',40,'B3');

INSERT INTO appuntamento (CodiceCliente,Durata,Descrizione,Tipo,Data,Ora,CodiceFiscale,CodiceSala,Modello,Marca,TempoUtilizzo) VALUES
    (1,'00:55',NULL,'CORPO','2020-12-01','11:00','MRTGNE97T48I495B','A5','phyllotaxis','Decomedical','00:50'),
    (18,'02:00', NULL, 'NESSUNO', '2020-12-01', '11:00', 'CYVRCK65L03D928R', 'B1', NULL, NULL, NULL),
    (2,'01:00',NULL,'NESSUNO','2020-12-01','16:00','STFRSR97M59I470F','A2',NULL,NULL,NULL),
    (4,'00:45',NULL,'NESSUNO','2020-12-01','13:00','BNGRLL91P51H987N','B2',NULL,NULL,NULL),
    (5,'01:30',NULL,'CORPO','2020-12-01','11:00','BNGRLL91P51H987N','A6','phyllotaxis','Decomedical','01:25'),
    (2,'00:30',NULL,'VISO','2020-12-02','11:00','FRNLNE97R48I480O','B3','796','ASDF','00:25'),
    (8,'00:25',NULL,'CORPO','2020-12-02','10:00','BNGRLL91P51H987N','A4','IPL 10000+ SalonPro','Beurer','00:20'),
    (20,'01:20',NULL,'VISO','2020-12-02','11:30','CYVRCK65L03D928R','B1','796','ASDF','01:15'),
    (11,'00:55',NULL,'NESSUNO','2020-12-02','15:00','PNGMLN00E66I696I','A3',NULL,NULL,NULL),
    (10,'00:50',NULL,'CORPO','2020-12-03','10:30','BNGRLL91P51H987N','A2','CAVISLIM PLUS YS35','Tecnovita','00:45'),
    (1,'00:40',NULL,'NESSUNO','2020-12-03','16:00','PNGMLN00E66I696I','B3',NULL,NULL,NULL),
    (2,'00:35',NULL,'NESSUNO','2020-12-04','15:00','CTTCLO94C47I400X','A2',NULL,NULL,NULL),
    (6,'00:45',NULL,'CORPO','2020-12-04','09:00','MRTGNE97T48I495B','A6','phyllotaxis','Decomedical','00:40'),
    (19,'01:00',NULL,'VISO','2020-12-05','9:45','FRNLNE97R48I480O','B1','796','ASDF','00:55'),
    (8,'00:50',NULL,'CORPO','2020-12-05','10:00','MRTGNE97T48I495B','A4','IPL 10000+ SalonPro','Beurer','00:45'),
    (15,'00:45',NULL,'CORPO','2020-12-05','10:00','BNGRLL91P51H987N','A6','CAVISLIM PLUS YS35','Tecnovita','00:40');

INSERT INTO Impiego (Modello,Marca,CodiceFiscale) VALUES
    ('phyllotaxis','Decomedical','MRTGNE97T48I495B'),
    ('phyllotaxis','Decomedical','BNGRLL91P51H987N'),
    ('796','ASDF','FRNLNE97R48I480O'),
    ('IPL 10000+ SalonPro','Beurer','BNGRLL91P51H987N'),
    ('796','ASDF','CYVRCK65L03D928R'),
    ('IPL 10000+ SalonPro','Beurer','MRTGNE97T48I495B'),
    ('FS 50','Beurer','BNGRLL91P51H987N'),
    ('FS 50','Beurer','CYVRCK65L03D928R'),
    ('CAVISLIM PLUS YS35','Tecnovita','BNGRLL91P51H987N'),
    ('CAVISLIM PLUS YS35','Tecnovita','MRTGNE97T48I495B');

INSERT INTO Locazione(Modello,Marca,CodiceSala) VALUES
    ('796','ASDF','B3'),
    ('796','ASDF','B1'),
    ('796','ASDF','A5'),
    ('phyllotaxis','Decomedical','A5'),
    ('phyllotaxis','Decomedical','A6'),
    ('IPL 10000+ SalonPro','Beurer','A4'),
    ('CAVISLIM PLUS YS35','Tecnovita','A3'),
    ('FS 50','Beurer','B2'),
    ('CAVISLIM PLUS YS35','Tecnovita','A2');
